function Ajax() {
    this.url = '';
    this.type = "";
    this.contentType = "";
    this.paramData = {};
    this.successCallFunc = null;
    this.failureCallFunc = null;
    this.completeCallFunc = null;
}

Ajax.get = function (url) {
    var ajax = new Ajax();
    ajax.type = "GET";
    ajax.url = url;
    this.contentType = "application/x-www-form-urlencoded";
    return ajax;
}

Ajax.post = function (url) {
    var ajax = new Ajax();
    ajax.type = "POST";
    ajax.url = url;
    ajax.contentType = "application/json;charset=UTF-8";
    return ajax;
}

Ajax.prototype.params = function (paramData) {
    if (this.type == "POST") {
        this.paramData = JSON.stringify(paramData);
    }else{
        this.paramData = paramData;
    }
    return this;
}

Ajax.prototype.success = function (successCallFunc) {
    this.successCallFunc = successCallFunc;
    return this;
}
Ajax.prototype.failure = function (failureCallFunc) {
    this.failureCallFunc= failureCallFunc;
    return this;
}
Ajax.prototype.complete = function (completeCallFunc) {
    this.completeCallFunc = completeCallFunc;
    return this;
}
Ajax.prototype.send = function () {
    var _this = this;
    var $ = layui.jquery;
    $.ajax({
        type: this.type,
        contentType: this.contentType,
        url: this.url,
        data: this.paramData,
        beforeSend: function () {
            this.layerIndex = layer.load(0, {shade: [0.5, '#393D49']});
        },
        success: function (result) {
            if (result.code == 0) {
                _this.successCallFunc && _this.successCallFunc(result.data);
            } else {
                layer.msg(result.message, {icon: 5});//失败的表情
                _this.failureCallFunc && _this.failureCallFunc();
            }
        },
        complete: function () {
            layer.close(this.layerIndex);
            _this.completeCallFunc && _this.completeCallFunc();
        },
    });
}

