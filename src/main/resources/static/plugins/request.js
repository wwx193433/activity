
/**
 * 增加 用户
 * @param userId
 */
function addUser() {
    layer.open({
        type: 2,
        title: '用户管理窗口',
        shadeClose: true,
        area: ['40%', '50%'],
        content: '/user/user_add'
    });
}

/**
 * 修改 用户
 * @param userId
 */
function editUser(userId) {
    layer.open({
        type: 2,
        title: '用户管理窗口',
        shadeClose: true,
        area: ['40%', '50%'],
        content: '/user/user_edit?userId='+userId
    });
}

/**
 * 删除用户
 * @param userId
 */
function removeUser(userId){
    var params = {
        userId: userId
    };
    Ajax.get("/user/remove")
        .params(params)
        .success(function(){
            layer.msg("删除成功!", {
                icon: 6,
                time: 1000
            }, function () {
                window.location.reload();
            });
        }).send();
}

/**
 * 分配角色
 * @param userId
 */
function setRole(userId) {
    layer.open({
        type: 2,
        title: '角色分配窗口',
        shadeClose: true,
        offset: ['0%'],
        area: ['40%', '50%'],
        content: '/user/role_select?userId=' + userId
    });
}

layui.use(['form', 'table', 'util'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = JSON.stringify(data.field);
        layer.alert(result, {
            title: '最终的搜索信息'
        });

        return false;
    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        addUser();
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            editUser(data.id);
        } else if (obj.event === 'setRole') {
            setRole(data.id);
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                removeUser(data.id)
                layer.close(index);
            });
        }
    });
});