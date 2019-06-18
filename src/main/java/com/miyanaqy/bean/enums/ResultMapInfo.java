package com.miyanaqy.bean.enums;

public enum ResultMapInfo {

    NOTPARAM(2, "参数不得为空"),
    GETSUCCESS(1, "获取成功"),
    GETFAIL(2, "获取失败"),
    ADDSUCCESS(1, "添加成功"),
    ADDFAIL(2, "添加失败"),
    EDITSUCCESS(1, "编辑成功"),
    EDITFAIL(2, "编辑失败"),
    DELETESUCCESS(1, "删除成功"),
    DELETEFAIL(2, "删除失败"),
    LONGINIPSUCCESS(1,"登入IP认证成功"),
    LONGINIPFAIL(2,"登入IP认证失败"),
    LOGININFOERRO(2,"用户名或密码错误"),
    ERROCODE(2,"验证码错误"),
    REPEATADDITION(2,"重复添加"),
    EXAMINEERROR(2, "审核状态异常"),
    SIGNERROR(2, "签名错误"),
    EXTRACTIONSUBSTITUTENOTENOUGH(2, "远程异常");


    private int code;

    private String message;

    private ResultMapInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public ResultMapInfo setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultMapInfo setMessage(String message) {
        this.message = message;
        return this;
    }
}
