package com.ybinsure.auth.service.tool;

public interface ConvertService {

    void convertPassword();

    void generateCompanyCode();

    void generateUserCode(int page, int size);
}
