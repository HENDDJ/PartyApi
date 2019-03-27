package com.cloudkeeper.leasing.utils;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.List;

import static com.cloudkeeper.leasing.utils.DefinitionUtil.*;
import static com.cloudkeeper.leasing.utils.GenerateTemplateCodeUtil.*;

class Content {

    @Nonnull
    static String getDomainContent() {
        return "package " + PackageSuffix.DOMAIN.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.domain.BaseEntity;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModel;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModelProperty;" +
                LINE_SEPARATOR +
                "import lombok.AllArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Getter;" +
                LINE_SEPARATOR +
                "import lombok.NoArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Setter;" +
                LINE_SEPARATOR +
                "import lombok.experimental.Accessors;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import javax.persistence.Column;" +
                LINE_SEPARATOR +
                "import javax.persistence.Entity;" +
                LINE_SEPARATOR +
                "import javax.persistence.Table;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + CLASS_EXPLAIN +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@ApiModel(value = \"" + CLASS_EXPLAIN + "\", description = \"" + CLASS_EXPLAIN + "\")" +
                LINE_SEPARATOR +
                "@Getter" +
                LINE_SEPARATOR +
                "@Setter" +
                LINE_SEPARATOR +
                "@Accessors(chain = true)" +
                LINE_SEPARATOR +
                "@NoArgsConstructor" +
                LINE_SEPARATOR +
                "@AllArgsConstructor" +
                LINE_SEPARATOR +
                "@Entity" +
                LINE_SEPARATOR +
                "@Table(name = \"" + TABLE_NAME + "\")" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.DOMAIN.getClassName() + " extends BaseEntity {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "/** 名称 */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiModelProperty(value = \"名称\", position = 10, required = true)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Column(length = 60)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "private String name;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    private static String fieldStr() {
        List<Field> fieldList = getField();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fieldList) {
            stringBuilder.append(fieldStr(field));
        }
        return stringBuilder.toString();
    }

    @Nonnull
    private static String fieldStr(@Nonnull Field field) {
        if (!BASIC_CLASS_TYPE_ALL.contains(field.getType().getSimpleName())) {
            return "";
        }
        ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
        StringBuilder stringBuilder = new StringBuilder();
        if (apiModelProperty != null && StringUtils.hasText(apiModelProperty.value())) {
            stringBuilder.append(TAB_SEPARATOR + "/** ").append(apiModelProperty.value()).append(" */");
            stringBuilder.append(LINE_SEPARATOR);
            stringBuilder.append(TAB_SEPARATOR + "@ApiModelProperty(value = \"").append(apiModelProperty.value()).append("\", position = ").append(apiModelProperty.position());
            if (apiModelProperty.required()) {
                stringBuilder.append(", required = true");
            }
            stringBuilder.append(")");
            stringBuilder.append(LINE_SEPARATOR);
        }
        stringBuilder.append(TAB_SEPARATOR + "private ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append(";");
        stringBuilder.append(LINE_SEPARATOR);
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

    @Nonnull
    static String getVOContent() {
        return "package " + PackageSuffix.VO.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.vo.BaseVO;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModel;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModelProperty;" +
                LINE_SEPARATOR +
                "import lombok.AllArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Getter;" +
                LINE_SEPARATOR +
                "import lombok.NoArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Setter;" +
                LINE_SEPARATOR +
                "import lombok.experimental.Accessors;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import java.math.BigDecimal;" +
                LINE_SEPARATOR +
                "import java.time.LocalDate;" +
                LINE_SEPARATOR +
                "import java.time.LocalDateTime;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.VO.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@ApiModel(value = \"" + PackageSuffix.VO.getExplain() + "\", description = \"" + PackageSuffix.VO.getExplain() + "\")" +
                LINE_SEPARATOR +
                "@Getter" +
                LINE_SEPARATOR +
                "@Setter" +
                LINE_SEPARATOR +
                "@Accessors(chain = true)" +
                LINE_SEPARATOR +
                "@NoArgsConstructor" +
                LINE_SEPARATOR +
                "@AllArgsConstructor" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.VO.getClassName() + " extends BaseVO {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                fieldStr() +
                "}";
    }

    @Nonnull
    static String getDTOContent() {
        return "package " + PackageSuffix.DTO.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.dto.BaseEditDTO;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModel;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModelProperty;" +
                LINE_SEPARATOR +
                "import lombok.AllArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Getter;" +
                LINE_SEPARATOR +
                "import lombok.NoArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Setter;" +
                LINE_SEPARATOR +
                "import lombok.experimental.Accessors;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import java.math.BigDecimal;" +
                LINE_SEPARATOR +
                "import java.time.LocalDate;" +
                LINE_SEPARATOR +
                "import java.time.LocalDateTime;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.DTO.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@ApiModel(value = \"" + PackageSuffix.DTO.getExplain() + "\", description = \"" + PackageSuffix.DTO.getExplain() + "\")" +
                LINE_SEPARATOR +
                "@Getter" +
                LINE_SEPARATOR +
                "@Setter" +
                LINE_SEPARATOR +
                "@Accessors(chain = true)" +
                LINE_SEPARATOR +
                "@NoArgsConstructor" +
                LINE_SEPARATOR +
                "@AllArgsConstructor" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.DTO.getClassName() + " extends BaseEditDTO {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                fieldStr() +
                "}";
    }

    @Nonnull
    static String getSearchableContent() {
        return "package " + PackageSuffix.SEARCHABLE.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.dto.BaseSearchable;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModel;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiModelProperty;" +
                LINE_SEPARATOR +
                "import lombok.AllArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Getter;" +
                LINE_SEPARATOR +
                "import lombok.NoArgsConstructor;" +
                LINE_SEPARATOR +
                "import lombok.Setter;" +
                LINE_SEPARATOR +
                "import lombok.experimental.Accessors;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import java.math.BigDecimal;" +
                LINE_SEPARATOR +
                "import java.time.LocalDate;" +
                LINE_SEPARATOR +
                "import java.time.LocalDateTime;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.SEARCHABLE.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@ApiModel(value = \"" + PackageSuffix.SEARCHABLE.getExplain() + "\", description = \"" + PackageSuffix.SEARCHABLE.getExplain() + "\")" +
                LINE_SEPARATOR +
                "@Getter" +
                LINE_SEPARATOR +
                "@Setter" +
                LINE_SEPARATOR +
                "@Accessors(chain = true)" +
                LINE_SEPARATOR +
                "@NoArgsConstructor" +
                LINE_SEPARATOR +
                "@AllArgsConstructor" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.SEARCHABLE.getClassName() + " extends BaseSearchable {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                fieldStr() +
                "}";
    }

    @Nonnull
    static String getRepositoryContent() {
        return "package " + PackageSuffix.REPOSITORY.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.repository.BaseRepository;" +
                LINE_SEPARATOR +
                "import org.springframework.stereotype.Repository;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.REPOSITORY.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@Repository" +
                LINE_SEPARATOR +
                "public interface " + PackageSuffix.REPOSITORY.getClassName() + " extends BaseRepository<" + PackageSuffix.DOMAIN.getClassName() + "> {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    static String getRepositoryTestContent() {
        return "package " + PackageSuffix.REPOSITORY_TEST.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import org.junit.Test;" +
                LINE_SEPARATOR +
                "import org.junit.runner.RunWith;" +
                LINE_SEPARATOR +
                "import org.springframework.beans.factory.annotation.Autowired;" +
                LINE_SEPARATOR +
                "import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;" +
                LINE_SEPARATOR +
                "import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;" +
                LINE_SEPARATOR +
                "import org.springframework.test.context.junit4.SpringRunner;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import static org.junit.Assert.*;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.REPOSITORY.getExplain() + " 测试" +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@RunWith(SpringRunner.class)" +
                LINE_SEPARATOR +
                "@DataJpaTest" +
                LINE_SEPARATOR +
                "@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.REPOSITORY_TEST.getClassName() + " {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "/** " + PackageSuffix.REPOSITORY.getExplain() + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Autowired" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "private " + PackageSuffix.REPOSITORY.getClassName() + " " + lowerCase(PackageSuffix.REPOSITORY.getClassName()) + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Test" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "public void saveTest() {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + CLASS_NAME + " " + lowerCase(CLASS_NAME) + " = new " + CLASS_NAME + "();" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + lowerCase(CLASS_NAME) + " = " + lowerCase(PackageSuffix.REPOSITORY.getClassName()) + ".save(" + lowerCase(CLASS_NAME) + ");" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "assertNotNull(" + lowerCase(CLASS_NAME) + ".getId());" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    static String getServiceContent() {
        return "package " + PackageSuffix.SERVICE.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.service.BaseService;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.SERVICE.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "public interface " + PackageSuffix.SERVICE.getClassName() + " extends BaseService<" + PackageSuffix.DOMAIN.getClassName() + "> {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    static String getServiceImplContent() {
        return "package " + PackageSuffix.SERVICE_IMPL.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.repository.BaseRepository;" +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.REPOSITORY.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.SERVICE.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import lombok.RequiredArgsConstructor;" +
                LINE_SEPARATOR +
                "import org.springframework.beans.factory.annotation.Autowired;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.ExampleMatcher;" +
                LINE_SEPARATOR +
                "import org.springframework.stereotype.Service;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.SERVICE.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@Service" +
                LINE_SEPARATOR +
                "@RequiredArgsConstructor(onConstructor = @__(@Autowired))" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.SERVICE_IMPL.getClassName() + " extends BaseServiceImpl<" + PackageSuffix.DOMAIN.getClassName() + "> implements " + PackageSuffix.SERVICE.getClassName() + " {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "/** " + PackageSuffix.REPOSITORY.getExplain() + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "private final " + PackageSuffix.REPOSITORY.getClassName() + " " + lowerCase(PackageSuffix.REPOSITORY.getClassName()) + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "protected BaseRepository<" + PackageSuffix.DOMAIN.getClassName() + "> getBaseRepository() {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "return " + lowerCase(PackageSuffix.REPOSITORY.getClassName()) + ";" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "public ExampleMatcher defaultExampleMatcher() {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "return super.defaultExampleMatcher()" + strFieldNameList() +
                ";" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    static String getServiceTestContent() {
        return "package " + PackageSuffix.SERVICE_TEST.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import lombok.extern.slf4j.Slf4j;" +
                LINE_SEPARATOR +
                "import org.junit.Test;" +
                LINE_SEPARATOR +
                "import org.junit.runner.RunWith;" +
                LINE_SEPARATOR +
                "import org.springframework.beans.factory.annotation.Autowired;" +
                LINE_SEPARATOR +
                "import org.springframework.boot.test.context.SpringBootTest;" +
                LINE_SEPARATOR +
                "import org.springframework.test.context.junit4.SpringRunner;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import static org.junit.Assert.*;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.SERVICE.getExplain() + " 测试" +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@RunWith(SpringRunner.class)" +
                LINE_SEPARATOR +
                "@SpringBootTest" +
                LINE_SEPARATOR +
                "@Slf4j" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.SERVICE_TEST.getClassName() + " {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "/** " + PackageSuffix.SERVICE.getExplain() + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Autowired" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "private " + PackageSuffix.SERVICE.getClassName() + " " + lowerCase(PackageSuffix.SERVICE.getClassName()) + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Test" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "public void saveTest() {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + CLASS_NAME + " " + lowerCase(CLASS_NAME) + " = new " + CLASS_NAME + "();" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + lowerCase(CLASS_NAME) + " = " + lowerCase(PackageSuffix.SERVICE.getClassName()) + ".save(" + lowerCase(CLASS_NAME) + ");" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "assertNotNull(" + lowerCase(CLASS_NAME) + ".getId());" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "}";
    }

    @Nonnull
    private static String strFieldNameList() {
        List<Field> fieldList = getField();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fieldList) {
            if (BASIC_CLASS_TYPE_STRING.contains(field.getType().getSimpleName()) && !field.getName().contains("Id") && !field.getName().equals("createdBy") && !field.getName().equals("modifiedBy")) {
                stringBuilder.append(LINE_SEPARATOR);
                stringBuilder.append(TAB_SEPARATOR).append(TAB_SEPARATOR).append(TAB_SEPARATOR).append(TAB_SEPARATOR);
                stringBuilder.append(".withMatcher(\"").append(field.getName()).append("\", ExampleMatcher.GenericPropertyMatchers.contains())");
            }
        }
        return stringBuilder.toString();
    }

    @Nonnull
    static String getControllerContent() {
        return "package " + PackageSuffix.CONTROLLER.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DTO.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.SEARCHABLE.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.VO.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.model.Result;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.Api;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiOperation;" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiParam;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Page;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Pageable;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Sort;" +
                LINE_SEPARATOR +
                "import org.springframework.validation.annotation.Validated;" +
                LINE_SEPARATOR +
                "import org.springframework.web.bind.annotation.*;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import java.util.List;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.CONTROLLER.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@Api(value = \"" + CLASS_EXPLAIN + "\", tags = \"" + CLASS_EXPLAIN + "\")" +
                LINE_SEPARATOR +
                "@RequestMapping(\"/" + lowerCase(CLASS_NAME) + "\")" +
                LINE_SEPARATOR +
                "public interface " + PackageSuffix.CONTROLLER.getClassName() + " {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 查询" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param id " + CLASS_EXPLAIN + "id" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return " + PackageSuffix.VO.getExplain() +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"查询\", notes = \"查询\", position = 1)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@GetMapping(\"/{id}id\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result<%s> findOne(@ApiParam(value = \"%sid\", required = true) @PathVariable String id);", PackageSuffix.VO.getClassName(), CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 新增" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param " + lowerCase(PackageSuffix.DTO.getClassName()) + " " + PackageSuffix.DTO.getExplain() +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return " + PackageSuffix.VO.getExplain() +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"新增\", notes = \"新增\", position = 2)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@PostMapping(\"/\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result<%s> add(@ApiParam(value = \"%s\", required = true) @RequestBody @Validated %s %s);",
                PackageSuffix.VO.getClassName(), PackageSuffix.DTO.getExplain(), PackageSuffix.DTO.getClassName(), lowerCase(PackageSuffix.DTO.getClassName())) +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 更新" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param id " + CLASS_EXPLAIN + "id" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param " + lowerCase(PackageSuffix.DTO.getClassName()) + " " + PackageSuffix.DTO.getExplain() +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return " + PackageSuffix.VO.getExplain() +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"更新\", notes = \"更新\", position = 3)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@PutMapping(\"/{id}id\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result<%s> update(@ApiParam(value = \"%sid\", required = true) @PathVariable String id,", PackageSuffix.VO.getClassName(), CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("@ApiParam(value = \"%s\", required = true) @RequestBody @Validated %s %s);",
                PackageSuffix.DTO.getExplain(), PackageSuffix.DTO.getClassName(), lowerCase(PackageSuffix.DTO.getClassName())) +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 删除" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param id " + CLASS_EXPLAIN + "id" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return 删除结果" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"删除\", notes = \"删除\", position = 4)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@DeleteMapping(\"/{id}id\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result delete(@ApiParam(value = \"%sid\", required = true) @PathVariable String id);", CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 列表查询" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param " + lowerCase(PackageSuffix.SEARCHABLE.getClassName()) + " " + CLASS_EXPLAIN + "查询条件" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param sort 排序条件" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return " + PackageSuffix.VO.getExplain() + " 集合" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"列表查询\", notes = \"列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc\", position = 5)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@PostMapping(\"/list\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result<List<%s>> list(@ApiParam(value = \"%s查询条件\", required = true) @RequestBody %s %s,",
                PackageSuffix.VO.getClassName(), CLASS_EXPLAIN, PackageSuffix.SEARCHABLE.getClassName(), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "@ApiParam(value = \"排序条件\", required = true) Sort sort);" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "/**" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * 分页查询" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param " + lowerCase(PackageSuffix.SEARCHABLE.getClassName()) + " " + CLASS_EXPLAIN + "查询条件" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @param pageable 分页条件" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " * @return " + PackageSuffix.VO.getExplain() + " 分页" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@ApiOperation(value = \"分页查询\", notes = \"分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc\", position = 6)" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@PostMapping(\"/page\")" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("Result<Page<%s>> page(@ApiParam(value = \"%s查询条件\", required = true) @RequestBody %s %s,",
                PackageSuffix.VO.getClassName(), CLASS_EXPLAIN, PackageSuffix.SEARCHABLE.getClassName(), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "@ApiParam(value = \"分页参数\", required = true) Pageable pageable);" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                "}";
    }

    @Nonnull
    static String getControllerImplContent() {
        return "package " + PackageSuffix.CONTROLLER_IMPL.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.model.Result;" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.CONTROLLER.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DTO.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.SEARCHABLE.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.SERVICE.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.VO.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import io.swagger.annotations.ApiParam;" +
                LINE_SEPARATOR +
                "import lombok.RequiredArgsConstructor;" +
                LINE_SEPARATOR +
                "import org.springframework.beans.BeanUtils;" +
                LINE_SEPARATOR +
                "import org.springframework.beans.factory.annotation.Autowired;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Page;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Pageable;" +
                LINE_SEPARATOR +
                "import org.springframework.data.domain.Sort;" +
                LINE_SEPARATOR +
                "import org.springframework.validation.annotation.Validated;" +
                LINE_SEPARATOR +
                "import org.springframework.web.bind.annotation.PathVariable;" +
                LINE_SEPARATOR +
                "import org.springframework.web.bind.annotation.RequestBody;" +
                LINE_SEPARATOR +
                "import org.springframework.web.bind.annotation.RestController;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import java.util.List;" +
                LINE_SEPARATOR +
                "import java.util.Optional;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.CONTROLLER.getExplain() +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "@RestController" +
                LINE_SEPARATOR +
                "@RequiredArgsConstructor(onConstructor = @__(@Autowired))" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.CONTROLLER_IMPL.getClassName() + " implements " + PackageSuffix.CONTROLLER.getClassName() + " {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "/** " + PackageSuffix.SERVICE.getExplain() + " */" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "private final " + PackageSuffix.SERVICE.getClassName() + " " + lowerCase(PackageSuffix.SERVICE.getClassName()) + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result<%s> findOne(@ApiParam(value = \"%sid\", required = true) @PathVariable String id) {", PackageSuffix.VO.getClassName(), CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("Optional<%s> %sOptional = %s.findOptionalById(id);", CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("return %sOptional.map(%s -> Result.of(%s.convert(%s.class))).orElseGet(Result::ofNotFound);",
                lowerCase(CLASS_NAME), lowerCase(CLASS_NAME), lowerCase(CLASS_NAME), PackageSuffix.VO.getClassName()) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result<%s> add(@ApiParam(value = \"%s\", required = true) @RequestBody @Validated %s %s) {",
                PackageSuffix.VO.getClassName(), PackageSuffix.DTO.getExplain(), PackageSuffix.DTO.getClassName(), lowerCase(PackageSuffix.DTO.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("%s %s = %s.save(%s.convert(%s.class));",
                CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName()), lowerCase(PackageSuffix.DTO.getClassName()), CLASS_NAME) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("return Result.ofAddSuccess(%s.convert(%s.class));", lowerCase(CLASS_NAME), PackageSuffix.VO.getClassName()) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result<%s> update(@ApiParam(value = \"%sid\", required = true) @PathVariable String id,", PackageSuffix.VO.getClassName(), CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("@ApiParam(value = \"%s\", required = true) @RequestBody @Validated %s %s) {",
                PackageSuffix.DTO.getExplain(), PackageSuffix.DTO.getClassName(), lowerCase(PackageSuffix.DTO.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("Optional<%s> %sOptional = %s.findOptionalById(id);", CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("if (!%sOptional.isPresent()) {", lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + "return Result.ofLost();" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("%s %s = %sOptional.get();", CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("BeanUtils.copyProperties(%s, %s);", lowerCase(PackageSuffix.DTO.getClassName()), lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("%s = %s.save(%s);", lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName()), lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("return Result.ofUpdateSuccess(%s.convert(%s.class));", lowerCase(CLASS_NAME), PackageSuffix.VO.getClassName()) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result delete(@ApiParam(value = \"%sid\", required = true) @PathVariable String id) {", CLASS_EXPLAIN) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("%s.deleteById(id);", lowerCase(PackageSuffix.SERVICE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "return Result.ofDeleteSuccess();" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result<List<%s>> list(@ApiParam(value = \"%s查询条件\", required = true) @RequestBody %s %s,",
                PackageSuffix.VO.getClassName(), CLASS_EXPLAIN, PackageSuffix.SEARCHABLE.getClassName(), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "@ApiParam(value = \"排序条件\", required = true) Sort sort) {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("List<%s> %sList = %s.findAll(%s, sort);",
                CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName()), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("List<%s> %sList = %s.convert(%sList, %s.class);",
                PackageSuffix.VO.getClassName(), lowerCase(PackageSuffix.VO.getClassName()), CLASS_NAME, lowerCase(CLASS_NAME), PackageSuffix.VO.getClassName()) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("return Result.of(%sList);", lowerCase(PackageSuffix.VO.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                TAB_SEPARATOR + "@Override" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + String.format("public Result<Page<%s>> page(@ApiParam(value = \"%s查询条件\", required = true) @RequestBody %s %s,",
                PackageSuffix.VO.getClassName(), CLASS_EXPLAIN, PackageSuffix.SEARCHABLE.getClassName(), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "@ApiParam(value = \"分页参数\", required = true) Pageable pageable) {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("Page<%s> %sPage = %s.findAll(%s, pageable);",
                CLASS_NAME, lowerCase(CLASS_NAME), lowerCase(PackageSuffix.SERVICE.getClassName()), lowerCase(PackageSuffix.SEARCHABLE.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("Page<%s> %sPage = %s.convert(%sPage, %s.class);",
                PackageSuffix.VO.getClassName(), lowerCase(PackageSuffix.VO.getClassName()), CLASS_NAME, lowerCase(CLASS_NAME), PackageSuffix.VO.getClassName()) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("return Result.of(%sPage);", lowerCase(PackageSuffix.VO.getClassName())) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                "}";
    }

    @Nonnull
    static String getControllerTestContent() {
        return "package " + PackageSuffix.CONTROLLER_TEST.getPackage() + ";" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import com.cloudkeeper.leasing.base.model.Result;" +
                LINE_SEPARATOR +
                "import " + PackageSuffix.DOMAIN.getFullClassName() + ";" +
                LINE_SEPARATOR +
                "import org.junit.Test;" +
                LINE_SEPARATOR +
                "import org.springframework.core.ParameterizedTypeReference;" +
                LINE_SEPARATOR +
                "import org.springframework.http.HttpEntity;" +
                LINE_SEPARATOR +
                "import org.springframework.http.HttpMethod;" +
                LINE_SEPARATOR +
                "import org.springframework.http.ResponseEntity;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "import static org.junit.Assert.*;" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                "/**" +
                LINE_SEPARATOR +
                " * " + PackageSuffix.CONTROLLER.getExplain() + " 测试" +
                LINE_SEPARATOR +
                " * @author " + DOC_AUTHOR +
                LINE_SEPARATOR +
                " */" +
                LINE_SEPARATOR +
                "public class " + PackageSuffix.CONTROLLER_TEST.getClassName() + " extends BaseControllerTest {" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "@Test" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "public void add() {" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("%s %s = new %s();", CLASS_NAME, lowerCase(CLASS_NAME), CLASS_NAME) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("HttpEntity<%s> httpEntity = new HttpEntity<>(%s, httpHeaders);", CLASS_NAME, lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("ParameterizedTypeReference<Result<%s>> type = new ParameterizedTypeReference<Result<%s>>() {};", CLASS_NAME, CLASS_NAME) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + String.format("ResponseEntity<Result<%s>> responseEntity = restTemplate.exchange(\"/%s/add\", HttpMethod.POST, httpEntity, type);", CLASS_NAME, lowerCase(CLASS_NAME)) +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "assertEquals(responseEntity.getStatusCodeValue(), 200);" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + TAB_SEPARATOR + "assertNotNull(responseEntity.getBody().getContent());" +
                LINE_SEPARATOR +
                TAB_SEPARATOR + "}" +
                LINE_SEPARATOR +
                LINE_SEPARATOR +

                "}";
    }

    @Nonnull
    static String getLiquibaseXML() {
        List<Field> fields = getField(true);
        StringBuilder xml = new StringBuilder();
        xml.append("-----------------------liquibase start----------------------");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + "<changeSet id=\"" + CHANGE_SET_ID + "\" author=\"").append(DOC_AUTHOR).append("\">");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + "<comment>" + CLASS_EXPLAIN + "表创建</comment>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + "<createTable tableName=\"").append(getTableName()).append("\" remarks=\"").append(CLASS_EXPLAIN).append("\">");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + "<column name=\"id\" type=\"varchar(36)\" remarks=\"主键id\">");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + "<constraints primaryKey=\"true\" nullable=\"false\" primaryKeyName=\"pk_").append(getTableName()).append("\"/>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + "</column>");
        xml.append(LINE_SEPARATOR);
        for (Field field : fields) {
            String fieldXml = getLiquibaseXML(field);
            if (!StringUtils.hasText(fieldXml)) {
                continue;
            }
            xml.append(fieldXml);
        }
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + "</createTable>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + "<rollback>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + "<dropTable tableName=\"").append(getTableName()).append("\"/>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + TAB_SEPARATOR + "</rollback>");
        xml.append(LINE_SEPARATOR);
        xml.append(TAB_SEPARATOR + "</changeSet>");
        xml.append(LINE_SEPARATOR);
        xml.append("-----------------------liquibase end----------------------");
        return xml.toString();
    }

    @Nonnull
    private static String getLiquibaseXML(@Nonnull Field field) {
        String fieldName = field.getName();
        String fieldType = "";
        String doc = "";
        Column column = field.getAnnotation(Column.class);
        if (column != null && StringUtils.hasText(column.name())) {
            fieldName = column.name();
        }
        if (BASIC_CLASS_TYPE_STRING.contains(field.getType().getSimpleName())) {
            if (column != null) {
                fieldType = "varchar(" + column.length() + ")";
            } else {
                fieldType = "varchar(255)";
            }
        } else if (BASIC_CLASS_TYPE_AMOUNT.contains(field.getType().getSimpleName())) {
            if (column != null) {
                if (StringUtils.hasText(column.columnDefinition())) {
                    fieldType = column.columnDefinition();
                }
            } else {
                fieldType = "double(16,4)";
            }
        } else if (BASIC_CLASS_TYPE_NUMBER.contains(field.getType().getSimpleName())) {
            if (column != null) {
                if (StringUtils.hasText(column.columnDefinition())) {
                    fieldType = column.columnDefinition();
                }
            } else {
                fieldType = "int";
            }
        } else if (BASIC_CLASS_TYPE_LOCAL_DATE.contains(field.getType().getSimpleName())) {
            fieldType = "date";
        } else if (BASIC_CLASS_TYPE_LOCAL_DATE_TIME.contains(field.getType().getSimpleName())) {
            fieldType = "datetime";
        } else {
            return "";
        }
        ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
        if (apiModelProperty != null) {
            doc = apiModelProperty.value();
        }
//        if (fieldName.equals("createdBy") || fieldName.equals("modifiedBy")) {
//            String suffix = fieldName.equals("createdBy") ? "_cby" : "_mby";
//            return TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR +
//                    "<column name=\"" + fieldName + "\" type=\"" + fieldType + "\" remarks=\"" + doc + "\">" +
//                    LINE_SEPARATOR +
//                    TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR +
//                    "<constraints referencedTableName=\"ck_id_principal\" referencedColumnNames=\"id\" foreignKeyName=\"fk_" + TABLE_NAME.toLowerCase() + suffix + "\"/>" +
//                    LINE_SEPARATOR +
//                    TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR +
//                    "</column>" +
//                    LINE_SEPARATOR;
//        }
        return TAB_SEPARATOR + TAB_SEPARATOR + TAB_SEPARATOR + String.format("<column name=\"%s\" type=\"%s\" remarks=\"%s\"/>", fieldName, fieldType, doc) + LINE_SEPARATOR;
    }
}
