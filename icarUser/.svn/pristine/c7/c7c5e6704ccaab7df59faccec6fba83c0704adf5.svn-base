package com.ybinsure.icar.user.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成DO
 *
 * @author HANHT
 * @version 2018/6/23 18:17
 */
public class Main {

    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<>();
            File configFile = new File("src/test/java/com/ybinsure/icar/user/mybatis/mybatis-generator-config.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException | InvalidConfigurationException | XMLParserException e) {
            e.printStackTrace();
        }
    }
}
