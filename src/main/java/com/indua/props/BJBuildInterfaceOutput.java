package com.indua.props;

import com.indua.utils.BJBuildStatus;

public class BJBuildInterfaceOutput {
    public static BJBuildInterfaceOutput CreateInstance() {
        return new BJBuildInterfaceOutput();
    }
    private String _interfaceName;
    private String _message;

    private BJBuildStatus _buildStatus;

    private BJBuildInterfaceOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    public String GetInterfaceName() {
        return _interfaceName;
    }

    public BJBuildInterfaceOutput SetInterfaceName(String _interfaceName) {
        this._interfaceName = _interfaceName;
        return this;
    }

    public String GetMessage() {
        return _message;
    }

    public BJBuildInterfaceOutput SetMessage(String _message) {
        this._message = _message;
        return this;
    }

    public BJBuildStatus GetBuildStatus() {
        return _buildStatus;
    }

    public BJBuildInterfaceOutput SetBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
