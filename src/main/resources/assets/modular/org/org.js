layui.use(['table', 'form', 'func', 'HttpRequest', 'util'], function () {
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var func = layui.func;
    var HttpRequest = layui.HttpRequest;
    var util = layui.util;

    // 职位表管理
    var Org = {
        tableId: "orgTable"
    };

    // 初始化表格的列
    Org.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'orgNo', sort: true, title: '机构编号'},
            {field: 'orgName', sort: true, title: '机构名称'},
            {field: 'status', sort: true, templet: '#statusTpl', title: '状态'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    // 点击查询按钮
    Org.search = function () {
        var queryData = {};
        queryData['orgNo'] = $("#orgNo").val();
        queryData['orgName'] = $("#orgName").val();
        table.reload(Org.tableId, {
            where: queryData,
            page: {curr: 1}
        });
    };

    // 弹出添加对话框
    Org.openAddDlg = function () {
        func.open({
            title: '添加职位',
            content: Feng.ctxPath + '/view/org/add',
            tableId: Org.tableId
        });
    };

    // 点击编辑
    Org.openEditDlg = function (data) {
        func.open({
            title: '修改职位',
            content: Feng.ctxPath + '/view/org/edit?orgId=' + data.id,
            tableId: Org.tableId
        });
    };

    // 导出excel按钮
    Org.exportExcel = function () {
        var checkRows = table.checkStatus(Org.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    // 点击删除
    // Org.delete = function (data) {
    //     var operation = function () {
    //         var httpRequest = new HttpRequest(Feng.ctxPath + "/org/delete", 'post', function (data) {
    //             Feng.success("删除成功!");
    //             table.reload(Org.tableId);
    //         }, function (data) {
    //             Feng.error("删除失败!" + data.message + "!");
    //         });
    //         httpRequest.set(data);
    //         httpRequest.start(true);
    //     };
    //     Feng.confirm("是否删除?", operation);
    // };

    // // 修改状态
    // Org.updateStatus = function (positionId, checked) {
    //     var httpRequest = new HttpRequest(Feng.ctxPath + "/hrPosition/updateStatus", 'post', function (data) {
    //         table.reload(Org.tableId);
    //         Feng.success("修改成功!");
    //     }, function (data) {
    //         table.reload(Org.tableId);
    //         Feng.error("修改失败!" + data.message);
    //     });
    //     httpRequest.set({"positionId": positionId, "statusFlag": checked});
    //     httpRequest.start(true);
    // };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Org.tableId,
        url: Feng.ctxPath + '/api/org/page',
        contentType: 'application/json',
        method: 'post',
        page: true,
        request: {pageName: 'pageNumber', limitName: 'pageSize'}, //自定义分页参数
        height: "full-158",
        cellMinWidth: 100,
        cols: Org.initColumn(),
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Org.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Org.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Org.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Org.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            Org.openEditDlg(data);
        } else if (event === 'delete') {
            Org.delete(data);
        }
    });

    // // 修改状态
    // form.on('switch(status)', function (obj) {
    //     var positionId = obj.elem.value;
    //     var checked = obj.elem.checked ? 1 : 2;
    //     Org.updateStatus(positionId, checked);
    // });
});
