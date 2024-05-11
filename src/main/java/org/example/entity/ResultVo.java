package org.example.entity;


//这个模拟的前后端交互的类
public class ResultVo {

    //返回结果
    Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }


    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    //结果说明
    String  resultString;
}
