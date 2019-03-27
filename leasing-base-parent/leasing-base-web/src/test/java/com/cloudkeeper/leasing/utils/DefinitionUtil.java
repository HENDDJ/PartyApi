package com.cloudkeeper.leasing.utils;

import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DefinitionUtil {

    ////////////////////////// 不定参 //////////////////////////////////
    /** 子工程名称 */
    private static final String PROJECT_NAME = GenerateTemplateCodeUtil.PROJECT_NAME;

    /** 类名 */
    private static final String CLASS_NAME = GenerateTemplateCodeUtil.CLASS_NAME;

    /** 类注释 */
    private static final String CLASS_EXPLAIN = GenerateTemplateCodeUtil.CLASS_EXPLAIN;

    /** 项目根目录 */
    private static final String PROJECT_DIR = "F:\\base-web-api\\";

    ////////////////////////// 定参 //////////////////////////////////
    /** 总工程名称 */
    private static String PARENT_PROJECT_NAME = "leasing";

    /** 包名前缀 */
    private static final String BASE_PACKAGE_PREFIX = "com.cloudkeeper." + PARENT_PROJECT_NAME + "." + PROJECT_NAME;

    /** 文件夹分隔符 */
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    /** 行分隔符 */
    static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /** tab分隔符 */
    static final String TAB_SEPARATOR = "    ";

    /** 基本数据类型 - 浮点数 */
    static final List<String> BASIC_CLASS_TYPE_AMOUNT = Arrays.asList("Float", "float", "Double", "double", "BigDecimal");

    /** 基本数据类型 - 整数 */
    static final List<String> BASIC_CLASS_TYPE_NUMBER = Arrays.asList("Byte", "byte", "shot", "Integer", "int", "Long", "long");

    /** 基本数据类型 - 字符 */
    static final List<String> BASIC_CLASS_TYPE_STRING = Arrays.asList("Char", "char", "String");

    /** 基本数据类型 - 布尔值 */
    static final List<String> BASIC_CLASS_TYPE_BOOLEAN = Arrays.asList("Boolean", "boolean");

    /** 基本数据类型 - 日期 */
    static final List<String> BASIC_CLASS_TYPE_LOCAL_DATE = Collections.singletonList("LocalDate");

    /** 基本数据类型 - 时间 */
    static final List<String> BASIC_CLASS_TYPE_LOCAL_DATE_TIME = Collections.singletonList("LocalDateTime");

    /** 基本数据类型 */
    static final List<String> BASIC_CLASS_TYPE_ALL = new ArrayList<>();

    static {
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_AMOUNT);
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_NUMBER);
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_STRING);
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_BOOLEAN);
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_LOCAL_DATE);
        BASIC_CLASS_TYPE_ALL.addAll(BASIC_CLASS_TYPE_LOCAL_DATE_TIME);
    }

    /**
     * 生成Java文件
     */
    static void generateJavaFile(PackageSuffix packageSuffix, String content) throws IOException {
        String dirPath = getDir(packageSuffix);
        String fileName = packageSuffix.getClassName();
        File fileDir = new File(dirPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File file = new File(dirPath + fileName + ".java");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }

    @Nonnull
    private static String getDir(@Nonnull PackageSuffix packageSuffix) {
        return PROJECT_DIR + packageSuffix.projectSuffix.getDir() + packageSuffix.env.getDir() + packageSuffix.getDir();
    }

    @Nonnull
    private static String packageConvertDir(String packageName) {
        String[] packageNames = packageName.split("\\.");
        StringBuilder packageDir = new StringBuilder();
        for (String packageNameItem : packageNames) {
            packageDir.append(packageNameItem);
            packageDir.append(FILE_SEPARATOR);
        }
        return packageDir.toString();
    }

    /***
     * 环境变量
     */
    public enum Env {
        JAVA,
        TEST;

        @Nonnull
        public String getDir() {
            String dir;
            switch (this) {
                case JAVA:
                    dir = "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "java" + FILE_SEPARATOR;
                    break;
                case TEST:
                    dir = "src" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "java" + FILE_SEPARATOR;
                    break;
                default:
                    dir = "";
            }
            return dir;
        }
    }

    public enum ProjectSuffix {
        /** 父工程名称后缀 */
        PARENT,
        /** 实体工程名称后缀 */
        POJO,
        /** 业务工程名称后缀 */
        SERVICE,
        /** 控制工程名称后缀 */
        WEB;

        public String getDir() {
            String dir = PARENT_PROJECT_NAME + "-" + PROJECT_NAME + "-" + PARENT.name().toLowerCase() + FILE_SEPARATOR;
            if (!this.equals(PARENT)) {
                dir += PARENT_PROJECT_NAME + "-" + PROJECT_NAME + "-" + this.name().toLowerCase() + FILE_SEPARATOR;
            }
            return dir;
        }
    }

    public enum PackageSuffix {
        /** domain包名 */
        DOMAIN(Env.JAVA, ProjectSuffix.POJO),
        /** dto包名 */
        DTO(Env.JAVA, ProjectSuffix.POJO),
        /** vo 包名 */
        VO(Env.JAVA, ProjectSuffix.POJO),
        /** 查询dto后缀 */
        SEARCHABLE(Env.JAVA, ProjectSuffix.POJO),
        /** repository 包名 */
        REPOSITORY(Env.JAVA, ProjectSuffix.SERVICE),
        /** repository 测试类 包名 */
        REPOSITORY_TEST(Env.TEST, ProjectSuffix.SERVICE),
        /** service 包名 */
        SERVICE(Env.JAVA, ProjectSuffix.SERVICE),
        /** service 实现类 包名 */
        SERVICE_IMPL(Env.JAVA, ProjectSuffix.SERVICE),
        /** service 测试类 包名 */
        SERVICE_TEST(Env.TEST, ProjectSuffix.SERVICE),
        /** controller 包名 */
        CONTROLLER(Env.JAVA, ProjectSuffix.WEB),
        /** controller 实现类 包名 */
        CONTROLLER_IMPL(Env.JAVA, ProjectSuffix.WEB),
        /** controller 测试类 包名 */
        CONTROLLER_TEST(Env.TEST, ProjectSuffix.WEB),
        ;

        private Env env;

        private ProjectSuffix projectSuffix;

        PackageSuffix(Env env, ProjectSuffix projectSuffix) {
            this.env = env;
            this.projectSuffix = projectSuffix;
        }

        @Nonnull
        public String getDir() {
            return packageConvertDir(getPackage());
        }

        @Nonnull
        public String getPackage() {
            String packageSuffix = this.name().toLowerCase();
            if (this.equals(SEARCHABLE)) {
                packageSuffix = DTO.name().toLowerCase();
            } else if (this.name().indexOf("_IMPL") > 0) {
                packageSuffix = PackageSuffix.valueOf(this.name().substring(0, this.name().indexOf("_IMPL"))).name().toLowerCase() + ".impl";
            } else if (this.name().indexOf("_TEST") > 0) {
                packageSuffix = PackageSuffix.valueOf(this.name().substring(0, this.name().indexOf("_TEST"))).name().toLowerCase();
            }
            String packageStr = BASE_PACKAGE_PREFIX + "." + packageSuffix;
            if (this.equals(DTO) || this.equals(SEARCHABLE)) {
                packageStr += "." + CLASS_NAME.toLowerCase();
            }
            return packageStr;
        }

        @Nonnull
        public String getClassName() {
            if (this.equals(DOMAIN)) {
                return CLASS_NAME;
            }
            String nameSuffix = upperCase(this.name().toLowerCase());
            if (this.equals(VO) || this.equals(DTO)) {
                nameSuffix = this.name();
            } else if (this.name().indexOf("_IMPL") > 0) {
                nameSuffix = upperCase(PackageSuffix.valueOf(this.name().substring(0, this.name().indexOf("_IMPL"))).name().toLowerCase()) + "Impl";
            } else if (this.name().indexOf("_TEST") > 0) {
                nameSuffix = upperCase(PackageSuffix.valueOf(this.name().substring(0, this.name().indexOf("_TEST"))).name().toLowerCase()) + "Test";
            }
            return CLASS_NAME + nameSuffix;
        }

        @Nonnull
        public String getFullClassName() {
            return getPackage() + "." + getClassName();
        }

        @Nonnull
        public String getExplain() {
            String explain;
            if (this.equals(SEARCHABLE)) {
                explain = "查询" + DTO.name();
            } else if (this.equals(VO) || this.equals(DTO)) {
                explain = this.name();
            } else {
                explain = this.name().toLowerCase();
            }

            return CLASS_EXPLAIN + " " + explain;
        }
    }

    static List<Field> getField() {
        return getField(false);
    }

    static List<Field> getField(boolean isXml) {
        return getField(getClazz(), isXml);
    }

    private static Class getClazz() {
        Class clazz = null;
        try {
            clazz = Class.forName(PackageSuffix.DOMAIN.getFullClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    @Nonnull
    static String getTableName() {
        Table table = (Table) getClazz().getAnnotation(Table.class);
        return table.name().toLowerCase();
    }

    private static List<Field> getField(@Nonnull Class clazz, boolean isXml) {
        List<Field> list = new ArrayList<>();
        if (isXml && clazz.getSuperclass() != null) {
            list.addAll(getField(clazz.getSuperclass(), true));
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // default public private protected static final
            // 0 1 2 4 8 16
            if ((field.getModifiers() & 2) == 2 && (field.getModifiers() & 8) != 8 && (field.getModifiers() & 16) != 16) {
                Transient annotation = field.getAnnotation(Transient.class);
                Id annotationId = field.getAnnotation(Id.class);
                if (!isXml || (annotation == null && annotationId == null)) {
                    list.add(field);
                }
            }
        }
        return list;
    }


    /**
     * 把一个字符串的第一个字母大写
     * @param fieldName 属性名称
     * @return 开头大写的字串
     * @author jerry.li
     */
    private static String upperCase(String fieldName) {
        if (!StringUtils.hasText(fieldName) || !Character.isLowerCase(fieldName.charAt(0))) {
            return fieldName;
        }
        char[] cs = fieldName.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 把一个字符串的第一个字母小写
     * @param fieldName 属性名称
     * @return 开头小写的字串
     * @author jerry.li
     */
    static String lowerCase(String fieldName) {
        if (!StringUtils.hasText(fieldName) || !Character.isUpperCase(fieldName.charAt(0))) {
            return fieldName;
        }
        char[] cs = fieldName.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }

}
