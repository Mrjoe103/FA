var table = layui.table;
var $ = layui.jquery;
var form = layui.form;
var layer = layui.layer;


$(function () {
    table.render({
        elem: '#roles',
        url: '../Role/queryAll.do', //数据接口
        page: true, // 开启分页
        limit: 10, // 每页显示的条数
        limits: [10, 20, 50, 100], // 每页条数的选择项
        loading: true, // 是否显示加载条(切换分页的时候显示）
        method:'get',   //请求方式
        toolbar: '#roleToolbar',   //自定义工具栏
        cols: [
            [ //表头
                {
                    type: 'checkbox',
                    fixed: 'left'
                },
                {
                    field: 'roleId',
                    title: '角色Id',
                    fixed: 'left',
                    align: 'center',
                    width: 160,
                    hide:true
                }, {
                    field: 'roleName',
                    title: '角色名',
                    align: 'center',
                    width: 150
                }, {
                field: 'usable',
                title: '是否可用',
                templet: function (d) {
                    if (d.usable==="Y"){
                        return '<span class="layui-btn layui-btn-xs ">' +
                            '可用' +
                            '</span>';
                    }else if(d.usable==="N"){
                        return '<span class="layui-btn layui-btn-xs layui-btn-radius layui-btn-danger">' +
                            '禁用' +
                            '</span>';
                    }
                },
                align: 'center',
                width: 100
                }, {
                    field: 'roleAbbr',
                    title: '简称',
                    width: 150,
                    align: 'center'
                }, {
                    field: 'description',
                    title: '描述',
                    align: 'center'
                }
            ]
        ]

    });

    //头部搜索按钮
    form.on('submit(roleSearchBtn)', function(data) {
        //渲染表单
        table.reload('roles', {
            url: '../Role/findRoleByCdWithPaging.do',
            where: { // 获取搜索框参数，作为请求参数
                roleName: $("#roleNameInput").val(),
                usable:$("#usable").val()
            },
            page: {
                curr: 1 //从第一页开始
            },
            limit: 10
        });
        return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //重置按钮点击事件，重新加载数据表格
    $("#refresh").click(function () {
        table.reload('roles', {
            url: '../Role/queryAll.do',
            page: {
                curr: 1 //从第一页开始
            },
            limit: 10
        });
        return false;
    });
});

/**
 * 格式化日期对象
 * @param time
 * @returns {string}
 */
function timeStamp2String(time){
    var datetime = new Date(time);
    //datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date +" "+hour+":"+minute+":"+second;
}


//监听头工具栏事件
    table.on('toolbar(data)', function(obj) {
        var checkStatus = table.checkStatus(obj.config.id),
            data = checkStatus.data; //获取选中的数据
        switch(obj.event) {
            case 'addRole':   //添加用户
                layer.open({
                    title: '添加用户',
                    type: 1,
                    skin: 'layui-layer-lan' ,//设置表头颜色
                    content: $("#addRole"),
                    area: ['400px', '450px'],
                    anim: 0, // 弹出动画
                    resize: false // 是否允许拉伸
                });

                //添加用户按钮提交
                form.on('submit(addUserSubBtn)', function (data) {
                    // 执行后台代码
                    $.ajax({
                        method: 'post',
                        url: '../Role/addRole.do',
                        data: {
                            roleName: $("#roleNameSubmit").val(),
                            roleAbbr: $("#roleAbbr").val(),
                            description: $("#description").val()
                        },
                        success: function (d) {
                            if (d === "YES") {
                                layer.msg("添加成功");
                                table.reload('roles', {
                                    method: 'get',
                                    url: '../Role/queryAll.do',
                                    page: {
                                        curr: 1 //从第一页开始
                                    },
                                    limit: 10
                                });
                                layer.closeAll();
                            } else {
                                layer.msg("业务繁忙，请稍后再试！")
                            }
                        }
                    });
                    return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
                });
                break;
            case 'updateRole':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else  if(data[0].usable ==='N'){
                    layer.msg('该用户已被禁用');
                } else{
                    //获取数据填入到对应的文本框中
                    $("#updateRoleName").attr("value", data[0].roleName);
                    $("#updateRoleAbbr").attr("values",data[0].roleAbbr);
                    $("#updateUsable").prepend('<option value="'+data[0].usable+'" selected>'+data[0].usable+'</option>')
                    $("#updateDescription").val(data[0].description);

                    //弹出模态框
                    layer.open({
                        title: '修改用户',
                        type: 1,
                        content: $("#updateRole"),
                        skin: 'layui-layer-lan' ,//设置表头颜色
                        area: ['400px', '450px'],
                        anim: 0, // 弹出动画
                        resize: false // 是否允许拉伸
                    });
                    //修改用户
                    form.on('submit(updateBtn)', function () {
                        //发送异步请求修改用户
                        $.ajax({
                            method: 'post',
                            url: '../Role/updateRole.do',
                            data: {
                                roleId:data[0].roleId,
                                roleName: $("#updateRoleName").val(),
                                roleAbbr: $("#updateRoleAbbr").val(),
                                usable:$("#updateUsable").val(),
                                description: $("#updateDescription").val()
                            },
                            success: function (d) {
                                if (d === "YES") {
                                    layer.msg("修改成功");
                                    table.reload('roles', {
                                        method: 'get',
                                        url: '../Role/queryAll.do',
                                        page: {
                                            curr: 1 //从第一页开始
                                        },
                                        limit: 10
                                    });
                                } else {
                                    layer.msg("业务繁忙，请稍后再试！")
                                }
                            }
                        });
                        layer.closeAll();
                        return false;
                    });

                    $("#cancel").click(function (index) {
                        layer.closeAll('page');
                    });
                }
                break;
            case 'frozenRecord':   //禁用用户
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if(data.length > 1){   //如果选中多行
                    var res = false;
                    for(var i = 0;i<data.length;i++){
                        if (data[i].usable==='N'){
                            layer.msg('当前选中行已存在被禁用户...');
                            return;
                        }else{
                            res = true;
                        }
                    }
                    if(res){
                        layer.confirm("是否禁用选中用户", {
                            title: "禁用",
                            icon: 3,
                            width: 300,
                            height: 400
                        }, function () { //用户确认后的回调函数
                            for(var i=0;i<data.length;i++){
                                $.ajax({
                                    method: 'post',
                                    url: '../Role/updateRole.do',
                                    data: {
                                        roleId: data[i].roleId,
                                        usable: "N"
                                    },
                                    success: function (result) {
                                        if (result === "YES") {
                                            layer.msg("已禁用");
                                            table.reload('roles', {
                                                method: 'get',
                                                url: '../Role/queryAll.do',
                                                page: {
                                                    curr: 1 //从第一页开始
                                                },
                                                limit: 10
                                            });
                                        } else {
                                            layer.msg("业务繁忙，请稍后再试！")
                                        }
                                    }
                                });
                            }
                            //关闭询问框
                            layer.closeAll();
                            //重新渲染表格
                            table.reload('roles', {
                                url: '../Role/queryAll.do'
                            });
                        });
                    }
                }else if(data[0].usable ==='N'){
                    layer.msg('该用户已被禁用');
                } else {
                    layer.confirm("是否禁用该用户", {
                        title: "禁用",
                        icon: 3,
                        width: 300,
                        height: 400
                    }, function () { //用户确认后的回调函数
                        $.ajax({
                            method: 'post',
                            url: '../Role/updateRole.do',
                            data: {
                                roleId: data[0].roleId,
                                usable: "N"
                            },
                            success: function (result) {
                                if (result === "YES") {
                                    layer.msg("已禁用");
                                    table.reload('roles', {
                                        method: 'get',
                                        url: '../Role/queryAll.do',
                                        page: {
                                            curr: 1 //从第一页开始
                                        },
                                        limit: 10
                                    });
                                } else {
                                    layer.msg("业务繁忙，请稍后再试！")
                                }
                            }
                        });
                        //关闭询问框
                        layer.closeAll();
                        //重新渲染表格
                        table.reload('roles', {
                            url: '../Role/queryAll.do'
                        });
                    });
                }
                break;
            case 'restoreRecord':  //解冻用户
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if(data.length > 1){  //如果选中多行数据
                    var result = false;
                    for(var k=0;k<data.length;k++){
                        if(data[k].usable ==='Y'){
                            layer.msg('当前选中行存在用户未被禁用');
                            return;
                        }else{
                            result = true;
                        }
                    }
                    if (result){
                        layer.confirm("是否确定所有选中用户", {
                            title: "解禁",
                            icon: 3,
                            width: 300,
                            height: 400
                        }, function () { //用户确认后的回调函数
                            for (var j=0;j<data.length;j++){
                                $.ajax({
                                    method:'post',
                                    url:'../Role/updateRole.do',
                                    data:{
                                        roleId:data[j].roleId,
                                        usable:"Y"
                                    },
                                    success:function (result) {
                                        if (result === "YES") {
                                            layer.msg("已解禁");
                                            table.reload('roles', {
                                                method:'get',
                                                url: '../Role/queryAll.do',
                                                page: {
                                                    curr: 1 //从第一页开始
                                                },
                                                limit: 10
                                            });
                                        } else {
                                            layer.msg("业务繁忙，请稍后再试！")
                                        }
                                    }
                                });
                            }
                            //关闭询问框
                            layer.closeAll();
                            //重新渲染表格
                            table.reload('roles', {
                                url: '../Role/queryAll.do'
                            });
                        });
                    }
                }else if(data[0].usable ==='Y'){
                    layer.msg('该用户未被禁用');
                } else {
                        layer.confirm("是否确定恢复该用户", {
                            title: "解禁",
                            icon: 3,
                            width: 300,
                            height: 400
                        }, function () { //用户确认后的回调函数
                            $.ajax({
                                method:'post',
                                url:'../Role/updateRole.do',
                                data:{
                                    roleId:data[0].roleId,
                                    usable:"Y"
                                },
                                success:function (result) {
                                    if (result === "YES") {
                                        layer.msg("已解禁");
                                        table.reload('roles', {
                                            method:'get',
                                            url: '../Role/queryAll.do',
                                            page: {
                                                curr: 1 //从第一页开始
                                            },
                                            limit: 10
                                        });
                                    } else {
                                        layer.msg("业务繁忙，请稍后再试！")
                                    }
                                }
                            });
                            //关闭询问框
                            layer.closeAll();
                            //重新渲染表格
                            table.reload('roles', {
                                url: '../Role/queryAll.do'
                            });
                        });
                    }
                    break;
                }
    });




