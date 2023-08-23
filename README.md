## 项目架构

- API: 负责处理请求和响应，以及与用户进行交互.
- Core: 负责处理应用程序的业务逻辑.
- Contract: 用于描述模型和接口之间的约定和规范，表示它们之间的交互协议或合同.

## 基于数据库的权限认证

## 表结构分析

### 用户表

- user_id
- username
- password
- enabled
- account_no_expired
- account_no_locked
- credentials_no_expired

### 角色权限表

- role_id
- role_name
- role_description

### 用户权限关联关系表(多对多)

- table_id
- role_id
- user_id

## OpenAPI3
```
 * @Api → @Tag
 * @ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden
 * @ApiImplicitParam → @Parameter
 * @ApiImplicitParams → @Parameters
 * @ApiModel → @Schema
 * @ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)
 * @ApiModelProperty → @Schema
 * @ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")
 * @ApiParam → @Parameter
 * @ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")
```
