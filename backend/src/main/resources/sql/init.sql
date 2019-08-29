/*
PostgreSQL Backup
Database: infection/public
Backup Time: 2019-08-29 13:57:52
*/

CREATE SEQUENCE "dict_code_set_seq_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "hibernate_sequence" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "opuser_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "seq_testca" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "seq_user" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "t_operator_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
CREATE TABLE "access_token_hos" (
  "access_token" text COLLATE "pg_catalog"."default" NOT NULL,
  "expires_in" int4,
  "create_time" timestamp(6) DEFAULT now(),
  "expire_time" timestamp(6)
)
CREATE TABLE "case_report" (
  "seq" int8 NOT NULL,
  "pid" varchar(30) COLLATE "pg_catalog"."default",
  "patient_name" varchar(50) COLLATE "pg_catalog"."default",
  "patient_type" varchar(10) COLLATE "pg_catalog"."default",
  "gender" varchar(2) COLLATE "pg_catalog"."default",
  "age" int4,
  "age_unit" varchar(4) COLLATE "pg_catalog"."default",
  "admission_time" timestamp(0),
  "admission_diag_code" varchar(255) COLLATE "pg_catalog"."default",
  "admission_diag_name" varchar(255) COLLATE "pg_catalog"."default",
  "infection_time" timestamp(0),
  "infection_diag_code" varchar(255) COLLATE "pg_catalog"."default",
  "infection_diag_name" varchar(255) COLLATE "pg_catalog"."default",
  "etiologic_ex" varchar(255) COLLATE "pg_catalog"."default",
  "etiologic_spec_name" varchar(255) COLLATE "pg_catalog"."default",
  "pathogen_code" varchar(255) COLLATE "pg_catalog"."default",
  "pathogen_name" varchar(255) COLLATE "pg_catalog"."default",
  "pre_factor" varchar(255) COLLATE "pg_catalog"."default",
  "pre_factor_else" varchar(255) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "op_code" varchar(10) COLLATE "pg_catalog"."default",
  "op_depid" varchar(10) COLLATE "pg_catalog"."default",
  "op_time" timestamp(0)
)
;COMMENT ON COLUMN "case_report"."seq" IS '主键';COMMENT ON COLUMN "case_report"."pid" IS '患者号';COMMENT ON COLUMN "case_report"."patient_name" IS '患者姓名';COMMENT ON COLUMN "case_report"."patient_type" IS '患者类别(门诊、住院)';COMMENT ON COLUMN "case_report"."gender" IS '性别';COMMENT ON COLUMN "case_report"."age" IS '年龄';COMMENT ON COLUMN "case_report"."age_unit" IS '年龄单位';COMMENT ON COLUMN "case_report"."admission_time" IS '入院时间';COMMENT ON COLUMN "case_report"."admission_diag_code" IS '入院诊断编码';COMMENT ON COLUMN "case_report"."admission_diag_name" IS '入院诊断名称';COMMENT ON COLUMN "case_report"."infection_time" IS '感染时间';COMMENT ON COLUMN "case_report"."infection_diag_code" IS '感染诊断编码';COMMENT ON COLUMN "case_report"."infection_diag_name" IS '感染诊断名称';COMMENT ON COLUMN "case_report"."etiologic_ex" IS '是否病原学检查';COMMENT ON COLUMN "case_report"."etiologic_spec_name" IS '病原学检查标本名称';COMMENT ON COLUMN "case_report"."pathogen_code" IS '病原体编码';COMMENT ON COLUMN "case_report"."pathogen_name" IS '病原体名称';COMMENT ON COLUMN "case_report"."pre_factor" IS '易感因素(用|分开)';COMMENT ON COLUMN "case_report"."pre_factor_else" IS '易感因素其他';COMMENT ON COLUMN "case_report"."remark" IS '备注';COMMENT ON COLUMN "case_report"."op_code" IS '报告人';COMMENT ON COLUMN "case_report"."op_depid" IS '报告科室';COMMENT ON COLUMN "case_report"."op_time" IS '报告时间';
CREATE TABLE "dict_code_set" (
  "seq" int8 NOT NULL,
  "field_code" varchar(255) COLLATE "pg_catalog"."default",
  "field_name" varchar(255) COLLATE "pg_catalog"."default",
  "dcode" varchar(255) COLLATE "pg_catalog"."default",
  "dname" varchar(255) COLLATE "pg_catalog"."default",
  "flag" char(1) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "dict_hsp" (
  "hsp_code" text COLLATE "pg_catalog"."default" NOT NULL,
  "hsp_name" text COLLATE "pg_catalog"."default",
  "organization_code" text COLLATE "pg_catalog"."default",
  "prov_id" text COLLATE "pg_catalog"."default",
  "city_id" text COLLATE "pg_catalog"."default",
  "county_id" text COLLATE "pg_catalog"."default",
  "street_id" text COLLATE "pg_catalog"."default",
  "addr_detail" text COLLATE "pg_catalog"."default",
  "hos_key" text COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_dept" (
  "dept_id" int8,
  "parent_id" int8,
  "dept_name" varchar(254) COLLATE "pg_catalog"."default",
  "order_num" float8,
  "create_time" timestamp(0),
  "modify_time" timestamp(0)
)
;
CREATE TABLE "t_dict" (
  "dict_id" int8,
  "keyy" int8,
  "valuee" varchar(254) COLLATE "pg_catalog"."default",
  "field_name" varchar(254) COLLATE "pg_catalog"."default",
  "table_name" varchar(254) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_job" (
  "job_id" int8,
  "bean_name" varchar(254) COLLATE "pg_catalog"."default",
  "method_name" varchar(254) COLLATE "pg_catalog"."default",
  "params" varchar(254) COLLATE "pg_catalog"."default",
  "cron_expression" varchar(254) COLLATE "pg_catalog"."default",
  "status" varchar(254) COLLATE "pg_catalog"."default",
  "remark" varchar(254) COLLATE "pg_catalog"."default",
  "create_time" date
)
;
CREATE TABLE "t_job_log" (
  "log_id" int8,
  "job_id" int8,
  "bean_name" varchar(254) COLLATE "pg_catalog"."default",
  "method_name" varchar(254) COLLATE "pg_catalog"."default",
  "params" varchar(254) COLLATE "pg_catalog"."default",
  "status" varchar(254) COLLATE "pg_catalog"."default",
  "error" text COLLATE "pg_catalog"."default",
  "times" float8,
  "create_time" date
)
;
CREATE TABLE "t_log" (
  "id" int8,
  "username" varchar(254) COLLATE "pg_catalog"."default",
  "operation" text COLLATE "pg_catalog"."default",
  "time" float8,
  "method" text COLLATE "pg_catalog"."default",
  "params" text COLLATE "pg_catalog"."default",
  "ip" varchar(254) COLLATE "pg_catalog"."default",
  "create_time" date,
  "location" varchar(254) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_login_log" (
  "username" varchar(254) COLLATE "pg_catalog"."default",
  "login_time" date,
  "location" varchar(254) COLLATE "pg_catalog"."default",
  "ip" varchar(254) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_menu" (
  "menu_id" int8,
  "parent_id" int8,
  "menu_name" varchar(254) COLLATE "pg_catalog"."default",
  "path" varchar(254) COLLATE "pg_catalog"."default",
  "component" varchar(254) COLLATE "pg_catalog"."default",
  "perms" varchar(254) COLLATE "pg_catalog"."default",
  "icon" varchar(254) COLLATE "pg_catalog"."default",
  "type" varchar(254) COLLATE "pg_catalog"."default",
  "order_num" float8,
  "create_time" timestamp(0),
  "modify_time" timestamp(0),
  "hidden" char(1) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_operator" (
  "id" int4 NOT NULL DEFAULT nextval('t_operator_id_seq'::regclass),
  "gender" varchar(50) COLLATE "pg_catalog"."default",
  "username" varchar(50) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_role" (
  "role_id" int8,
  "role_name" varchar(254) COLLATE "pg_catalog"."default",
  "remark" varchar(254) COLLATE "pg_catalog"."default",
  "create_time" date,
  "modify_time" date
)
;
CREATE TABLE "t_role_menu" (
  "role_id" int8,
  "menu_id" int8
)
;
CREATE TABLE "t_test" (
  "filed1" varchar(254) COLLATE "pg_catalog"."default",
  "filed2" int4,
  "filed3" varchar(254) COLLATE "pg_catalog"."default",
  "create_time" date
)
;
CREATE TABLE "t_user" (
  "user_id" int8,
  "username" varchar(254) COLLATE "pg_catalog"."default",
  "password" varchar(254) COLLATE "pg_catalog"."default",
  "dept_id" int8,
  "email" varchar(254) COLLATE "pg_catalog"."default",
  "mobile" varchar(254) COLLATE "pg_catalog"."default",
  "status" varchar(254) COLLATE "pg_catalog"."default",
  "modify_time" timestamp(0),
  "last_login_time" timestamp(0),
  "ssex" varchar(254) COLLATE "pg_catalog"."default",
  "description" varchar(254) COLLATE "pg_catalog"."default",
  "avatar" varchar(254) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "real_name" varchar(254) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_user_config" (
  "user_id" int8,
  "theme" varchar(254) COLLATE "pg_catalog"."default",
  "layout" varchar(254) COLLATE "pg_catalog"."default",
  "multi_page" varchar(254) COLLATE "pg_catalog"."default",
  "fix_siderbar" varchar(254) COLLATE "pg_catalog"."default",
  "fix_header" varchar(254) COLLATE "pg_catalog"."default",
  "color" varchar(254) COLLATE "pg_catalog"."default"
)
;
CREATE TABLE "t_user_role" (
  "seq" int8 NOT NULL,
  "user_id" int8,
  "role_id" int8
)
;
CREATE VIEW "user_view" AS  SELECT t.user_id,
    t.username,
    t.password,
    t.dept_id,
    t.email,
    t.mobile,
    t.status,
    t.modify_time,
    t.last_login_time,
    t.ssex,
    t.description,
    t.avatar,
    t.create_time,
    t.real_name,
    array_to_string(group_concat(a.role_id), ','::text) AS role_id,
    array_to_string(group_concat(b.role_name), ','::text) AS role_name,
    c.dept_name,
    c.parent_id
   FROM (((t_user t
     LEFT JOIN t_user_role a ON ((a.user_id = t.user_id)))
     LEFT JOIN t_role b ON ((b.role_id = a.role_id)))
     LEFT JOIN t_dept c ON ((c.dept_id = t.dept_id)))
  GROUP BY t.user_id, t.username, t.password, t.dept_id, t.email, t.mobile, t.status, t.modify_time, t.last_login_time, t.ssex, t.description, t.avatar, t.create_time, t.real_name, c.dept_name, c.parent_id;
BEGIN;
LOCK TABLE "public"."access_token_hos" IN SHARE MODE;
DELETE FROM "public"."access_token_hos";
INSERT INTO "public"."access_token_hos" ("access_token","expires_in","create_time","expire_time") VALUES ('eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNDkxNDc0MzcyIiwiZXhwIjoxNTk4NTQ0MDAwfQ.Tchg9B_mehOjDibe3jrekmCG_Zq5ZRV6evxjh8-0IDU', 86400, '2019-08-28 10:26:05.612', '2019-08-29 10:26:05.612');
COMMIT;
BEGIN;
LOCK TABLE "public"."case_report" IN SHARE MODE;
DELETE FROM "public"."case_report";
INSERT INTO "public"."case_report" ("seq","pid","patient_name","patient_type","gender","age","age_unit","admission_time","admission_diag_code","admission_diag_name","infection_time","infection_diag_code","infection_diag_name","etiologic_ex","etiologic_spec_name","pathogen_code","pathogen_name","pre_factor","pre_factor_else","remark","op_code","op_depid","op_time") VALUES (2109, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in4', NULL, '0', 'dsfad', NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', '3213', NULL, NULL, NULL, NULL),(2110, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in5', NULL, '0', '12312f', NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', NULL, NULL, NULL, NULL, NULL),(2111, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in1', NULL, '0', '232', NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', NULL, NULL, NULL, NULL, NULL),(2112, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in5', NULL, NULL, 'dfasd', NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', '213213', NULL, NULL, NULL, NULL),(2113, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in4', NULL, NULL, 'df', NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', '1232312dfd', NULL, NULL, NULL, NULL),(2114, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in2', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL),(2153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'in1', NULL, NULL, NULL, NULL, NULL, 'diabetes,antibiotic,cirrhosis,drug-addict,radiotherapy,immunosuppressor,ventilator,surgery,else', NULL, NULL, NULL, NULL, NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."dict_code_set" IN SHARE MODE;
DELETE FROM "public"."dict_code_set";
INSERT INTO "public"."dict_code_set" ("seq","field_code","field_name","dcode","dname","flag") VALUES (1, 'infecSiteClass', '感染部位分类', 'respiratorySystem', '呼吸系统', NULL),(3, 'infecSiteClass', '感染部位分类', 'digestiveSystem', '消化系统', NULL),(2, 'infecSiteClass', '感染部位分类', 'urinarySystem', '泌尿系统', NULL),(4, 'infecSiteClass', '感染部位分类', 'boneAndJoint', '骨和关节', NULL),(5, 'infecSiteClass', '感染部位分类', 'centralNervousSystem', '中枢神经系统', NULL),(6, 'infecSiteClass', '感染部位分类', 'cardiovascularSystem', '心血管系统', NULL),(7, 'infecSiteClass', '感染部位分类', 'blood', '血液', NULL),(8, 'infecSiteClass', '感染部位分类', 'genitalSystem', '生殖系统', NULL),(9, 'infecSiteClass', '感染部位分类', 'skinAndSoftTissue', '皮肤和软组织', NULL),(10, 'infecSiteClass', '感染部位分类', 'surgicalSpot', '手术部位', NULL),(11, 'infecSiteClass', '感染部位分类', 'earNoseThroatMouth', '耳、鼻、咽、喉、口腔和眼', NULL),(12, 'infecSiteClass', '感染部位分类', 'general', '全身', NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."dict_hsp" IN SHARE MODE;
DELETE FROM "public"."dict_hsp";
INSERT INTO "public"."dict_hsp" ("hsp_code","hsp_name","organization_code","prov_id","city_id","county_id","street_id","addr_detail","hos_key") VALUES ('1491474372', '本溪满族自治县第一人民医院', '46315701-2', '21', '2103', '210323', NULL, NULL, 'mRKbJ6P4yC6kQkPtG+Cicw==');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_dept" IN SHARE MODE;
DELETE FROM "public"."t_dept";
INSERT INTO "public"."t_dept" ("dept_id","parent_id","dept_name","order_num","create_time","modify_time") VALUES (1, 0, '开发部', 1, '2018-01-04 00:00:00', '2019-01-05 00:00:00'),(2, 1, '开发一部', 1, '2018-01-04 00:00:00', '2019-04-23 00:00:00'),(3, 1, '开发二部', 2, '2018-01-04 00:00:00', '2019-01-05 00:00:00'),(4, 0, '市场部', 2, '2018-01-04 00:00:00', '2019-04-23 00:00:00'),(5, 0, '人事部', 3, '2018-01-04 00:00:00', '2019-01-23 00:00:00'),(6, 0, '测试部', 4, '2018-01-04 00:00:00', '2019-01-17 00:00:00'),(2152, 6, '测试1', 1, '2019-08-12 00:00:00', NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."t_dict" IN SHARE MODE;
DELETE FROM "public"."t_dict";
INSERT INTO "public"."t_dict" ("dict_id","keyy","valuee","field_name","table_name") VALUES (1, 0, '男', 'ssex', 't_user'),(2, 1, '女', 'ssex', 't_user'),(3, 2, '保密', 'ssex', 't_user'),(4, 1, '有效', 'status', 't_user'),(5, 0, '锁定', 'status', 't_user'),(6, 0, '菜单', 'type', 't_menu'),(7, 1, '按钮', 'type', 't_menu'),(30, 0, '正常', 'status', 't_job'),(31, 1, '暂停', 'status', 't_job'),(32, 0, '成功', 'status', 't_job_log'),(33, 1, '失败', 'status', 't_job_log');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_job" IN SHARE MODE;
DELETE FROM "public"."t_job";
INSERT INTO "public"."t_job" ("job_id","bean_name","method_name","params","cron_expression","status","remark","create_time") VALUES (1, 'testTask', 'test', 'mrbird', '0/1 * * * * ?1', '1', '有参任务调度测试', '2018-02-24'),(2, 'testTask', 'test1', NULL, '0/10 * * * * ?', '1', '无参任务调度测试', '2018-02-24'),(3, 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '有参任务调度测试,每隔一秒触发', '2018-02-26'),(11, 'testTask', 'test2', NULL, '0/5 * * * * ?', '1', '测试异常', '2018-02-26');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_job_log" IN SHARE MODE;
DELETE FROM "public"."t_job_log";
INSERT INTO "public"."t_job_log" ("log_id","job_id","bean_name","method_name","params","status","error","times","create_time") VALUES (2450, 3, 'testTask', 'test', 'hello world', '0', NULL, 2, '2018-03-20'),(2451, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20'),(2452, 3, 'testTask', 'test', 'hello world', '0', NULL, 2, '2018-03-20'),(2453, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2454, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20'),(2455, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2456, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2457, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2458, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2459, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20'),(2460, 3, 'testTask', 'test', 'hello world', '0', NULL, 5, '2018-03-20'),(2461, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2462, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2463, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2464, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20'),(2465, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.job.task.TestTask.test2()', 0, '2018-03-20'),(2466, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02'),(2467, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02'),(2468, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02'),(2469, 2, 'testTask', 'test1', NULL, '0', NULL, 3, '2018-04-02'),(2476, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2477, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', 0, '2019-01-06'),(2478, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2479, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2480, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2481, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2482, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2483, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2484, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2485, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2486, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2487, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2488, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2489, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2490, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2491, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2492, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-01-06'),(2493, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2494, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-01-06'),(2495, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', 2, '2019-01-06'),(2496, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', 0, '2019-01-06'),(2497, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', 1, '2019-01-06'),(2498, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2019-01-06'),(2499, 1, 'testTask', 'test', 'mrbird', '0', NULL, 30, '2019-01-22'),(2500, 1, 'testTask', 'test', 'mrbird', '0', NULL, 9, '2019-01-23'),(2501, 1, 'testTask', 'test', 'mrbird', '0', NULL, 12, '2019-01-24');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_log" IN SHARE MODE;
DELETE FROM "public"."t_log";
INSERT INTO "public"."t_log" ("id","username","operation","time","method","params","ip","create_time","location") VALUES (1815, 'mrbird', '删除用户', 301, 'cc.mrbird.febs.system.controller.UserController.deleteUsers()', ' userIds: "11"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1816, 'mrbird', '修改菜单/按钮', 170, 'cc.mrbird.febs.system.controller.MenuController.updateMenu()', ' menu: "Menu(menuId=2, parentId=0, menuName=系统监控, path=/monitor, component=PageView, perms=null, icon=dashboard, type=0, orderNum=2.0, createTime=null, modifyTime=Wed Jan 23 14:27:12 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1817, 'mrbird', '修改部门', 90, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=4, parentId=0, deptName=市场部, orderNum=2.0, createTime=null, modifyTime=Wed Jan 23 14:27:55 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1818, 'mrbird', '修改部门', 596, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=5, parentId=0, deptName=人事部, orderNum=3.0, createTime=null, modifyTime=Wed Jan 23 14:27:59 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1819, 'mrbird', '执行定时任务', 146, 'cc.mrbird.febs.job.controller.JobController.runJob()', ' jobId: "1"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1820, 'mrbird', '新增菜单/按钮', 160, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=130, parentId=3, menuName=导出Excel, path=null, component=null, perms=user:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:35:15 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1821, 'mrbird', '新增菜单/按钮', 255, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=131, parentId=4, menuName=导出Excel, path=null, component=null, perms=role:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:35:36 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1822, 'mrbird', '新增菜单/按钮', 172, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=132, parentId=5, menuName=导出Excel, path=null, component=null, perms=menu:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:04 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1823, 'mrbird', '新增菜单/按钮', 188, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=133, parentId=6, menuName=导出Excel, path=null, component=null, perms=dept:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:24 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1824, 'mrbird', '新增菜单/按钮', 186, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=134, parentId=64, menuName=导出Excel, path=null, component=null, perms=dict:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:43 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1825, 'mrbird', '新增菜单/按钮', 160, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=135, parentId=3, menuName=密码重置, path=null, component=null, perms=user:reset, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:59 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1826, 'mrbird', '新增菜单/按钮', 181, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=136, parentId=10, menuName=导出Excel, path=null, component=null, perms=log:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:37:26 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1827, 'mrbird', '新增菜单/按钮', 146, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=137, parentId=102, menuName=导出Excel, path=null, component=null, perms=job:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:37:59 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1828, 'mrbird', '新增菜单/按钮', 164, 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: "Menu(menuId=138, parentId=109, menuName=导出Excel, path=null, component=null, perms=jobLog:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:38:32 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1829, 'mrbird', '修改角色', 3132, 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: "Role(roleId=1, roleName=管理员, remark=管理员, createTime=null, modifyTime=Wed Jan 23 14:45:28 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=1,3,11,12,13,4,14,15,16,5,17,18,19,6,20,21,22,64,65,66,67,2,8,23,10,24,113,121,122,124,123,125,101,102,103,104,105,106,107,108,109,110,58,59,61,81,82,83,127,128,129,130,135,131,132,133,134,136,137,138)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1830, 'mrbird', '修改角色', 1730, 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: "Role(roleId=2, roleName=注册用户, remark=只可查看不可操作, createTime=null, modifyTime=Wed Jan 23 15:31:07 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1831, 'mrbird', '修改角色', 1997, 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: "Role(roleId=2, roleName=注册用户, remark=可查看，新增，导出, createTime=null, modifyTime=Wed Jan 23 15:32:20 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129,130,14,17,132,20,133,65,134,136,103,137,138)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1832, 'mrbird', '新增角色', 1428, 'cc.mrbird.febs.system.controller.RoleController.addRole()', ' role: "Role(roleId=72, roleName=普通用户, remark=只可查看，好可怜哦, createTime=Wed Jan 23 15:33:20 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null, menuId=1,3,4,5,6,64,2,8,10,113,121,122,124,123,127,101,102,109,58,59,61,81,82,83,128,129)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1833, 'mrbird', '新增用户', 338, 'cc.mrbird.febs.system.controller.UserController.addUser()', ' user: "User(userId=12, username=jack, password=552649f10640385d0728a80a4242893e, deptId=6, deptName=null, email=jack@hotmail.com, mobile=null, status=1, createTime=Wed Jan 23 15:34:05 CST 2019, modifyTime=null, lastLoginTime=null, ssex=0, description=null, avatar=default.jpg, roleId=72, roleName=null, sortField=null, sortOrder=null, createTimeFrom=null, createTimeTo=null, id=null)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1834, 'mrbird', '修改角色', 2160, 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: "Role(roleId=2, roleName=注册用户, remark=可查看，新增，导出, createTime=null, modifyTime=Wed Jan 23 15:37:08 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129,130,14,17,132,20,133,65,134,136,103,137,138,131)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1835, 'mrbird', '新增角色', 169, 'cc.mrbird.febs.system.controller.RoleController.addRole()', ' role: "Role(roleId=73, roleName=测试xss, remark=<style>body{background:red !important}</style>, createTime=Wed Jan 23 15:47:04 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null, menuId=1,3)"', '127.0.0.1', '2019-01-23', '内网IP|0|0|内网IP|内网IP'),(1836, 'mrbird', '删除角色', 54, 'cc.mrbird.febs.system.controller.RoleController.deleteRoles()', ' roleIds: "73"', '218.104.237.213', '2019-01-24', '中国|华东|福建省|福州市|联通'),(1837, 'mrbird', '修改用户', 39, 'cc.mrbird.febs.system.controller.UserController.updateUser()', ' user: "User(userId=12, username=jack, password=null, deptId=6, deptName=null, email=jack@hotmail.com, mobile=null, status=1, createTime=null, modifyTime=Thu Jan 24 11:08:00 CST 2019, lastLoginTime=null, ssex=0, description=null, avatar=null, roleId=72, roleName=null, sortField=null, sortOrder=null, createTimeFrom=null, createTimeTo=null, id=null)"', '218.104.237.213', '2019-01-24', '中国|华东|福建省|福州市|联通'),(1838, 'mrbird', '执行定时任务', 41, 'cc.mrbird.febs.job.controller.JobController.runJob()', ' jobId: "1"', '218.104.237.213', '2019-01-24', '中国|华东|福建省|福州市|联通'),(1839, 'mrbird', '新增用户', 43, 'cc.mrbird.febs.system.controller.UserController.addUser()', ' user: "User(userId=13, username=test, password=1c9a231a07da290d3286500bdd5fe8a9, deptId=1, deptName=null, email=null, mobile=null, status=1, createTime=Tue Apr 23 15:21:07 CST 2019, modifyTime=null, lastLoginTime=null, ssex=0, description=null, avatar=default.jpg, roleId=2, roleName=null, sortField=null, sortOrder=null, createTimeFrom=null, createTimeTo=null, id=null)"', '127.0.0.1', '2019-04-23', NULL),(1840, 'mrbird', '删除用户', 38, 'cc.mrbird.febs.system.controller.UserController.deleteUsers()', ' userIds: "13"', '127.0.0.1', '2019-04-23', NULL),(1841, 'mrbird', '修改部门', 21, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=4, parentId=0, deptName=市场部, orderNum=2.5, createTime=null, modifyTime=Tue Apr 23 16:45:17 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL),(1842, 'mrbird', '修改部门', 15, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=2, parentId=4, deptName=开发一部, orderNum=1.0, createTime=null, modifyTime=Tue Apr 23 16:45:36 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL),(1843, 'mrbird', '修改部门', 17, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=2, parentId=3, deptName=开发一部, orderNum=1.0, createTime=null, modifyTime=Tue Apr 23 16:45:56 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL),(1844, 'mrbird', '修改部门', 13, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=2, parentId=1, deptName=开发一部, orderNum=1.0, createTime=null, modifyTime=Tue Apr 23 16:46:05 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL),(1845, 'mrbird', '修改部门', 15, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=2, parentId=1, deptName=开发一部, orderNum=-1.0, createTime=null, modifyTime=Tue Apr 23 16:46:28 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL),(1846, 'mrbird', '修改部门', 16, 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: "Dept(deptId=2, parentId=1, deptName=开发一部, orderNum=1.0, createTime=null, modifyTime=Tue Apr 23 16:46:38 CST 2019, createTimeFrom=null, createTimeTo=null)"', '127.0.0.1', '2019-04-23', NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."t_login_log" IN SHARE MODE;
DELETE FROM "public"."t_login_log";
INSERT INTO "public"."t_login_log" ("username","login_time","location","ip") VALUES ('mrbird', '2019-01-12', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-10', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-12', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbirdd', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('jack', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('abcd', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('abcd', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('abcd', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('abcd', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('wuyouzhugu', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('hello', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('hello', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('hello', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('scott', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('jack', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('scott', '2019-01-24', '中国|华东|福建省|厦门市|电信', '120.36.172.239'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('jack', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('scott', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('scott', '2019-01-24', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-24', '中国|华东|福建省|福州市|电信', '27.155.195.27'),('scott', '2019-01-24', '中国|华东|福建省|福州市|电信', '27.155.195.27'),('mrbird', '2019-01-28', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-01-28', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('scott', '2019-01-28', '中国|华东|福建省|福州市|联通', '218.104.237.213'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('jack', '2019-04-23', NULL, '127.0.0.1'),('scott', '2019-04-23', NULL, '127.0.0.1'),('scott', '2019-04-23', NULL, '127.0.0.1'),('scott', '2019-04-23', NULL, '127.0.0.1'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('jack', '2019-04-23', NULL, '127.0.0.1'),('scott', '2019-04-23', NULL, '127.0.0.1'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('test', '2019-04-23', NULL, '127.0.0.1'),('test', '2019-04-23', NULL, '127.0.0.1'),('test', '2019-04-23', NULL, '127.0.0.1'),('test', '2019-04-23', NULL, '127.0.0.1'),('test', '2019-04-23', NULL, '127.0.0.1'),('mrbird', '2019-04-23', NULL, '127.0.0.1'),('jack', '2019-04-23', NULL, '127.0.0.1'),('jack', '2019-04-26', NULL, '127.0.0.1'),('jack', '2019-04-26', NULL, '127.0.0.1'),('jack', '2019-04-26', NULL, '127.0.0.1'),('jack', '2019-05-05', NULL, '127.0.0.1'),('jack', '2019-05-06', NULL, '127.0.0.1'),('jack', '2019-05-09', NULL, '127.0.0.1'),('mrbird', '2019-05-09', NULL, '127.0.0.1'),('mrbird', '2019-05-22', NULL, '127.0.0.1'),('mrbird', '2019-05-22', NULL, '127.0.0.1'),('mrbird', '2019-05-22', NULL, '127.0.0.1'),('mrbird', '2019-05-28', NULL, '127.0.0.1'),('mrbird', '2019-05-28', NULL, '127.0.0.1'),('mrbird', '2019-05-28', NULL, '127.0.0.1'),('mrbird', '2019-05-28', NULL, '127.0.0.1'),('mrbird', '2019-05-29', '', '127.0.0.1'),('mrbird', '2019-05-29', '', '127.0.0.1'),('mrbird', '2019-05-29', '', '127.0.0.1'),('mrbird', '2019-05-29', '', '127.0.0.1');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_menu" IN SHARE MODE;
DELETE FROM "public"."t_menu";
INSERT INTO "public"."t_menu" ("menu_id","parent_id","menu_name","path","component","perms","icon","type","order_num","create_time","modify_time","hidden") VALUES (1, 0, '系统管理', '/system', 'PageView', NULL, 'appstore-o', '0', 1, '2017-12-27 00:00:00', '2019-01-05 00:00:00', NULL),(2, 0, '系统监控', '/monitor', 'PageView', NULL, 'dashboard', '0', 2, '2017-12-27 00:00:00', '2019-01-23 00:00:00', NULL),(3, 1, '用户管理', '/system/user', 'system/user/User', 'user:view', NULL, '0', 1, '2017-12-27 00:00:00', '2019-01-22 00:00:00', NULL),(4, 1, '角色管理', '/system/role', 'system/role/Role', 'role:view', NULL, '0', 2, '2017-12-27 00:00:00', '2018-04-25 00:00:00', NULL),(5, 1, '菜单管理', '/system/menu', 'system/menu/Menu', 'menu:view', NULL, '0', 3, '2017-12-27 00:00:00', '2018-04-25 00:00:00', NULL),(6, 1, '部门管理', '/system/dept', 'system/dept/Dept', 'dept:view', NULL, '0', 4, '2017-12-27 00:00:00', '2018-04-25 00:00:00', NULL),(8, 2, '在线用户', '/monitor/online', 'monitor/Online', 'user:online', NULL, '0', 1, '2017-12-27 00:00:00', '2018-04-25 00:00:00', NULL),(10, 2, '系统日志', '/monitor/systemlog', 'monitor/SystemLog', 'log:view', NULL, '0', 2, '2017-12-27 00:00:00', '2018-04-25 00:00:00', NULL),(11, 3, '新增用户', NULL, NULL, 'user:add', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(12, 3, '修改用户', NULL, NULL, 'user:update', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(13, 3, '删除用户', NULL, NULL, 'user:delete', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(14, 4, '新增角色', NULL, NULL, 'role:add', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(15, 4, '修改角色', NULL, NULL, 'role:update', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(16, 4, '删除角色', NULL, NULL, 'role:delete', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(17, 5, '新增菜单', NULL, NULL, 'menu:add', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(18, 5, '修改菜单', NULL, NULL, 'menu:update', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(19, 5, '删除菜单', NULL, NULL, 'menu:delete', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(20, 6, '新增部门', NULL, NULL, 'dept:add', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(21, 6, '修改部门', NULL, NULL, 'dept:update', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(22, 6, '删除部门', NULL, NULL, 'dept:delete', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(23, 8, '踢出用户', NULL, NULL, 'user:kickout', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(24, 10, '删除日志', NULL, NULL, 'log:delete', NULL, '1', NULL, '2017-12-27 00:00:00', NULL, NULL),(64, 1, '字典管理', '/system/dict', 'system/dict/Dict', 'dict:view', NULL, '0', 5, '2018-01-18 00:00:00', '2018-04-25 00:00:00', NULL),(65, 64, '新增字典', NULL, NULL, 'dict:add', NULL, '1', NULL, '2018-01-18 00:00:00', NULL, NULL),(66, 64, '修改字典', NULL, NULL, 'dict:update', NULL, '1', NULL, '2018-01-18 00:00:00', NULL, NULL),(67, 64, '删除字典', NULL, NULL, 'dict:delete', NULL, '1', NULL, '2018-01-18 00:00:00', NULL, NULL),(101, 0, '任务调度', '/job', 'PageView', NULL, 'clock-circle-o', '0', 3, '2018-01-11 00:00:00', NULL, NULL),(102, 101, '定时任务', '/job/job', 'quartz/job/Job', 'job:view', NULL, '0', 1, '2018-02-24 00:00:00', '2019-01-22 00:00:00', NULL),(103, 102, '新增任务', NULL, NULL, 'job:add', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(104, 102, '修改任务', NULL, NULL, 'job:update', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(105, 102, '删除任务', NULL, NULL, 'job:delete', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(106, 102, '暂停任务', NULL, NULL, 'job:pause', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(107, 102, '恢复任务', NULL, NULL, 'job:resume', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(108, 102, '立即执行任务', NULL, NULL, 'job:run', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(109, 101, '调度日志', '/job/log', 'quartz/log/JobLog', 'jobLog:view', NULL, '0', 2, '2018-02-24 00:00:00', '2019-01-22 00:00:00', NULL),(110, 109, '删除日志', NULL, NULL, 'jobLog:delete', NULL, '1', NULL, '2018-02-24 00:00:00', NULL, NULL),(113, 2, 'Redis监控', '/monitor/redis/info', 'monitor/RedisInfo', 'redis:view', NULL, '0', 3, '2018-06-28 00:00:00', NULL, NULL),(121, 2, '请求追踪', '/monitor/httptrace', 'monitor/Httptrace', NULL, NULL, '0', 4, '2019-01-18 00:00:00', NULL, NULL),(122, 2, '系统信息', '/monitor/system', 'EmptyPageView', NULL, NULL, '0', 5, '2019-01-18 00:00:00', '2019-01-18 00:00:00', NULL),(123, 122, 'Tomcat信息', '/monitor/system/tomcatinfo', 'monitor/TomcatInfo', NULL, NULL, '0', 2, '2019-01-18 00:00:00', '2019-01-18 00:00:00', NULL),(124, 122, 'JVM信息', '/monitor/system/jvminfo', 'monitor/JvmInfo', NULL, NULL, '0', 1, '2019-01-18 00:00:00', '2019-01-18 00:00:00', NULL),(127, 122, '服务器信息', '/monitor/system/info', 'monitor/SystemInfo', NULL, NULL, '0', 3, '2019-01-21 00:00:00', '2019-01-21 00:00:00', NULL),(128, 0, '其他模块', '/others', 'PageView', NULL, 'coffee', '0', 5, '2019-01-22 00:00:00', '2019-01-22 00:00:00', NULL),(129, 128, '导入导出', '/others/excel', 'others/Excel', NULL, NULL, '0', 1, '2019-01-22 00:00:00', '2019-01-22 00:00:00', NULL),(130, 3, '导出Excel', NULL, NULL, 'user:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(131, 4, '导出Excel', NULL, NULL, 'role:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(132, 5, '导出Excel', NULL, NULL, 'menu:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(133, 6, '导出Excel', NULL, NULL, 'dept:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(134, 64, '导出Excel', NULL, NULL, 'dict:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(135, 3, '密码重置', NULL, NULL, 'user:reset', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(136, 10, '导出Excel', NULL, NULL, 'log:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(137, 102, '导出Excel', NULL, NULL, 'job:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(138, 109, '导出Excel', NULL, NULL, 'jobLog:export', NULL, '1', NULL, '2019-01-23 00:00:00', NULL, NULL),(139, 58, '病历上报', '/infection/report', 'infection/Report', '', NULL, '0', 1, '2019-05-31 00:00:00', '2019-05-31 00:00:00', NULL),(59, 58, '目标监测', '/web/weather', 'web/Weather', 'weather:view', NULL, '0', 2, '2018-01-12 00:00:00', '2019-01-22 00:00:00', NULL),(61, 58, '病例监测', '/web/dailyArticle', 'web/DailyArticle', 'article:view', NULL, '0', 3, '2018-01-15 00:00:00', '2019-01-22 00:00:00', NULL),(81, 58, '预警', '/web/movie', 'EmptyPageView', NULL, NULL, '0', 4, '2018-01-22 00:00:00', '2019-01-22 00:00:00', NULL),(58, 0, '院感系统', '/web', 'PageView', NULL, 'compass', '0', 5, '2018-01-12 00:00:00', '2018-01-22 00:00:00', NULL),(140, 0, '病历上报新增', '/infection/report/add', 'infection/ReportAdd', NULL, '', '0', NULL, NULL, NULL, '1');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_operator" IN SHARE MODE;
DELETE FROM "public"."t_operator";
INSERT INTO "public"."t_operator" ("id","gender","username") VALUES (1, 'male', 'jack'),(2, 'female', 'rose');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_role" IN SHARE MODE;
DELETE FROM "public"."t_role";
INSERT INTO "public"."t_role" ("role_id","role_name","remark","create_time","modify_time") VALUES (1, '管理员', '管理员', '2017-12-27', '2019-01-23'),(2, '注册用户', '可查看，新增，导出', '2019-01-04', '2019-01-23'),(72, '普通用户', '只可查看，好可怜哦', '2019-01-23', '2019-08-12');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_role_menu" IN SHARE MODE;
DELETE FROM "public"."t_role_menu";
INSERT INTO "public"."t_role_menu" ("role_id","menu_id") VALUES (1, 1),(1, 3),(1, 11),(1, 12),(1, 13),(1, 4),(1, 14),(1, 15),(1, 16),(1, 5),(1, 17),(1, 18),(1, 19),(1, 6),(1, 20),(1, 21),(1, 22),(1, 64),(1, 65),(1, 66),(1, 67),(1, 2),(1, 8),(1, 23),(1, 10),(1, 24),(1, 113),(1, 121),(1, 122),(1, 124),(1, 123),(1, 125),(1, 101),(1, 102),(1, 103),(1, 104),(1, 105),(1, 106),(1, 107),(1, 108),(1, 109),(1, 110),(1, 58),(1, 59),(1, 61),(1, 81),(1, 82),(1, 83),(1, 127),(1, 128),(1, 129),(1, 130),(1, 135),(1, 131),(1, 132),(1, 133),(1, 134),(1, 136),(1, 137),(1, 138),(72, 1),(72, 3),(72, 4),(72, 5),(72, 6),(72, 64),(72, 2),(72, 8),(72, 10),(72, 113),(72, 121),(72, 122),(72, 124),(72, 123),(72, 127),(72, 101),(72, 102),(72, 109),(72, 58),(72, 59),(72, 61),(72, 81),(72, 82),(72, 83),(72, 128),(72, 129),(2, 3),(2, 1),(2, 4),(2, 5),(2, 6),(2, 64),(2, 2),(2, 8),(2, 10),(2, 113),(2, 121),(2, 122),(2, 124),(2, 123),(2, 125),(2, 101),(2, 102),(2, 109),(2, 58),(2, 59),(2, 61),(2, 81),(2, 82),(2, 83),(2, 127),(2, 128),(2, 129),(2, 130),(2, 14),(2, 17),(2, 132),(2, 20),(2, 133),(2, 65),(2, 134),(2, 136),(2, 103),(2, 137),(2, 138),(2, 131),(1, 139),(1, 140);
COMMIT;
BEGIN;
LOCK TABLE "public"."t_test" IN SHARE MODE;
DELETE FROM "public"."t_test";
INSERT INTO "public"."t_test" ("filed1","filed2","filed3","create_time") VALUES ('字段1', 1, 'mrbird@gmail.com', '2019-01-22'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', NULL, 'mrbird9@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', NULL, 'mrbird9@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', 6, 'mrbird5@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', NULL, 'mrbird9@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', 6, 'mrbird5@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', 6, 'mrbird5@gmail.com', '2019-01-23'),('字段1', 1, 'mrbird0@gmail.com', '2019-01-23'),('字段1', 2, 'mrbird1@gmail.com', '2019-01-23'),('字段1', 3, 'mrbird2@gmail.com', '2019-01-23'),('字段1', 4, 'mrbird3@gmail.com', '2019-01-23'),('字段1', 5, 'mrbird4@gmail.com', '2019-01-23'),('字段1', 6, 'mrbird5@gmail.com', '2019-01-23'),('字段1', 7, 'mrbird6@gmail.com', '2019-01-23'),('字段1', 8, 'mrbird7@gmail.com', '2019-01-23'),('字段1', NULL, 'mrbird8@gmail.com', '2019-01-23'),('字段1', 11, 'mrbird10@gmail.com', '2019-01-23'),('字段1', 12, 'mrbird11@gmail.com', '2019-01-23'),('字段1', 14, 'mrbird13@gmail.com', '2019-01-23'),('字段1', 15, 'mrbird14@gmail.com', '2019-01-23'),('字段1', 16, 'mrbird15@gmail.com', '2019-01-23'),('字段1', 18, 'mrbird17@gmail.com', '2019-01-23'),('字段1', 19, 'mrbird18@gmail.com', '2019-01-23'),('字段1', 20, 'mrbird19@gmail.com', '2019-01-23');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_user" IN SHARE MODE;
DELETE FROM "public"."t_user";
INSERT INTO "public"."t_user" ("user_id","username","password","dept_id","email","mobile","status","modify_time","last_login_time","ssex","description","avatar","create_time","real_name") VALUES (2143, 'test', '1c9a231a07da290d3286500bdd5fe8a9', 3, 'asd123@gmail.com', '13123123118', '1', NULL, NULL, '0', NULL, 'default.jpg', '2019-08-12 10:35:30', 'test'),(2146, 'test2', 'e9ac2d2d0b5fe6174b838607e7c989ed', 2, 'asd123@gmail.com', '13123123118', '1', NULL, NULL, '1', NULL, 'default.jpg', '2019-08-12 10:35:47', 'test2'),(2149, '6666', '45c533f834ba2d900b6919d255afc1d7', 4, 'asd123@gmail.com', '13123123118', '1', NULL, NULL, '2', NULL, 'default.jpg', '2019-08-12 10:36:24', 'test3'),(9999, '9999', 'e944a15cfc16fe42eae59a844d998053', 1, 'cyrus@163.com', '13123123118', '1', '2019-08-09 11:05:11', NULL, '0', 'admin', 'c7c4ee7be3eb4e73a19887dc713505145.jpg', '2019-08-09 11:05:18', '管理员'),(1, 'mrbird', 'cd90fdddbe4eb9abf3b55ea8f8195ec5', 6, 'asd123@gmail.com', '13123123118', '1', '2019-01-26 04:00:02', '2019-01-24 00:00:00', '0', '我是aas', 'a3b10296862e40edb811418d64455d00.jpeg', '2019-03-09 17:29:48', 'Mrbird'),(2, 'admin', '11e7ba3ddc9e58e411cf83b85f5ba29a', 1, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."t_user_config" IN SHARE MODE;
DELETE FROM "public"."t_user_config";
INSERT INTO "public"."t_user_config" ("user_id","theme","layout","multi_page","fix_siderbar","fix_header","color") VALUES (2116, 'dark', 'head', '0', '1', '1', 'rgb(66, 185, 131)'),(2118, 'dark', 'head', '0', '1', '1', 'rgb(66, 185, 131)'),(2121, 'dark', 'head', '0', '1', '1', 'rgb(66, 185, 131)'),(1, 'light', 'head', '0', '1', '1', 'rgb(47, 84, 235)'),(9999, 'light', 'head', '0', '1', '1', 'rgb(47, 84, 235)'),(2143, 'light', 'head', '0', '1', '1', 'rgb(66, 185, 131)'),(2146, 'light', 'head', '0', '1', '1', 'rgb(66, 185, 131)'),(2149, 'light', 'head', '0', '1', '1', 'rgb(66, 185, 131)');
COMMIT;
BEGIN;
LOCK TABLE "public"."t_user_role" IN SHARE MODE;
DELETE FROM "public"."t_user_role";
INSERT INTO "public"."t_user_role" ("seq","user_id","role_id") VALUES (1, 1, 1),(2, 9999, 1),(2144, 2143, 2),(2145, 2143, 72),(2147, 2146, 2),(2148, 2146, 72),(2150, 2149, 2),(2151, 2149, 72);
COMMIT;
ALTER TABLE "access_token_hos" ADD CONSTRAINT "access_token_hos_pkey" PRIMARY KEY ("access_token");
ALTER TABLE "case_report" ADD CONSTRAINT "case_report_pkey" PRIMARY KEY ("seq");
ALTER TABLE "dict_code_set" ADD CONSTRAINT "dict_code_set_pkey" PRIMARY KEY ("seq");
ALTER TABLE "dict_hsp" ADD CONSTRAINT "dict_hsp_pkey" PRIMARY KEY ("hsp_code");
ALTER TABLE "t_operator" ADD CONSTRAINT "t_operator_pkey" PRIMARY KEY ("id");
ALTER TABLE "t_user_role" ADD CONSTRAINT "t_user_role_pkey" PRIMARY KEY ("seq");
SELECT setval('"dict_code_set_seq_seq"', 3, false);
SELECT setval('"hibernate_sequence"', 2155, true);
SELECT setval('"opuser_seq"', 4, true);
SELECT setval('"seq_testca"', 4, false);
SELECT setval('"seq_user"', 4, false);
ALTER SEQUENCE "t_operator_id_seq"
OWNED BY "t_operator"."id";
SELECT setval('"t_operator_id_seq"', 4, true);
