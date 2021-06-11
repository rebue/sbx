-- 领域
INSERT INTO RAC_DOMAIN(ID, NAME, REMARK) VALUES ('default', '默认领域', '系统和账户的默认领域');
INSERT INTO RAC_DOMAIN(ID, NAME, REMARK) VALUES ('platform', '平台领域', '平台管理领域');
INSERT INTO RAC_DOMAIN(ID, NAME, REMARK) VALUES ('ops', '运营领域', '运营管理领域');
-- 系统
INSERT INTO RAC_SYS (ID, NAME, DOMAIN_ID,MENU,REMARK) VALUES ('platform-admin-web', '平台后台管理', 'platform','[{"key":"/base","title":"基础","children":[{"key":"/base/rac-domain","title":"领域"},{"key":"/base/rac-sys","title":"系统"},{"key":"/base/rac-perm","title":"权限"},{"key":"/base/rac-role","title":"角色"}]},{"key":"/account","title":"账户","children":[{"key":"/account/rac-org","title":"组织"},{"key":"/account/rac-account","title":"账户"}]},{"key":"/log","title":"日志","children":[{"key":"/log/lock-log","title":"锁定日志"},{"key":"/log/op-log","title":"操作日志"}]}]','对平台的后台管理提供最基本的功能');
INSERT INTO RAC_SYS (ID, NAME, DOMAIN_ID,REMARK) VALUES ('ops-admin-web', '运营后台管理', 'ops','对运营的后台管理提供最基本的功能');

-- 空账号
INSERT INTO RAC_ACCOUNT (ID,DOMAIN_ID,SIGN_IN_NAME,SIGN_IN_PSWD,SIGN_IN_PSWD_SALT,SIGN_IN_NICKNAME,CREATE_TIMESTAMP,UPDATE_TIMESTAMP)VALUES(0,'platform','null','','','空',UNIX_TIMESTAMP(SYSDATE()) * 1000,UNIX_TIMESTAMP(SYSDATE()) * 1000);
-- 系统账号
INSERT INTO RAC_ACCOUNT (ID,DOMAIN_ID,SIGN_IN_NAME,SIGN_IN_PSWD,SIGN_IN_PSWD_SALT,SIGN_IN_NICKNAME,CREATE_TIMESTAMP,UPDATE_TIMESTAMP)VALUES(1,'platform','system','','','系统',UNIX_TIMESTAMP(SYSDATE()) * 1000,UNIX_TIMESTAMP(SYSDATE()) * 1000);
-- 平台管理员
INSERT INTO RAC_ACCOUNT (ID,DOMAIN_ID,SIGN_IN_NAME,SIGN_IN_PSWD,SIGN_IN_PSWD_SALT,SIGN_IN_NICKNAME,SIGN_IN_AVATAR,CREATE_TIMESTAMP,UPDATE_TIMESTAMP)VALUES(10,'platform','super','05eeac84965236b8a479c3ebef3a2dc4','dX3jbg','平台管理员','/img/account/tiger.jpg',UNIX_TIMESTAMP(SYSDATE()) * 1000,UNIX_TIMESTAMP(SYSDATE()) * 1000);
-- 运营管理员
INSERT INTO RAC_ACCOUNT (ID,DOMAIN_ID,SIGN_IN_NAME,SIGN_IN_PSWD,SIGN_IN_PSWD_SALT,SIGN_IN_NICKNAME,SIGN_IN_AVATAR,CREATE_TIMESTAMP,UPDATE_TIMESTAMP)VALUES(20,'ops','admin','28bac2dc3862a24b376314014d8ef920','zcSeWA','运营管理员','/img/account/9527.jpg',UNIX_TIMESTAMP(SYSDATE()) * 1000,UNIX_TIMESTAMP(SYSDATE()) * 1000);

-- 角色
INSERT INTO RAC_ROLE(ID, NAME, DOMAIN_ID, IS_ENABLED, SEQ_NO, REMARK)VALUES(1,'平台管理员','platform',true,0,'平台管理员');
INSERT INTO RAC_ACCOUNT_ROLE(ID, ROLE_ID, ACCOUNT_ID)VALUES(1,1,10);
INSERT INTO RAC_ROLE(ID, NAME, DOMAIN_ID, IS_ENABLED, SEQ_NO, REMARK)VALUES(2,'运营管理员','ops',true,0,'运营管理员');
INSERT INTO RAC_ACCOUNT_ROLE(ID, ROLE_ID, ACCOUNT_ID)VALUES(2,2,20);
-- 权限
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1,'platform','领域',true,0,'领域');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(2,'platform','系统',true,1,'系统');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(3,'platform','权限',true,2,'权限');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(4,'platform','角色',true,3,'角色');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(5,'platform','组织',true,4,'组织');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(6,'platform','账户',true,5,'账户');
INSERT INTO RAC_PERM_GROUP(ID, DOMAIN_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(7,'platform','日志',true,6,'日志');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1001,'platform',1,'管理领域',true,0,'拥有管理领域的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1002,'platform',1,'查看领域',true,1,'拥有查看领域的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1003,'platform',2,'管理系统',true,0,'拥有管理系统的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1004,'platform',2,'查看系统',true,1,'拥有查看系统的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1005,'platform',3,'管理权限',true,0,'拥有管理权限的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1006,'platform',3,'查看权限',true,1,'拥有查看权限的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1007,'platform',4,'管理角色',true,0,'拥有管理角色的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1008,'platform',4,'查看角色',true,1,'拥有查看角色的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1009,'platform',5,'管理组织',true,0,'拥有管理组织的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1010,'platform',5,'查看组织',true,1,'拥有查看组织的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1011,'platform',6,'管理账户',true,0,'拥有管理账户的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1012,'platform',6,'查看账户',true,1,'拥有查看账户的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1013,'platform',7,'查看锁定日志',true,0,'拥有查看锁定日志的权限');
INSERT INTO RAC_PERM(ID, DOMAIN_ID, GROUP_ID, NAME, IS_ENABLED, SEQ_NO, REMARK)VALUES(1014,'platform',7,'查看操作日志',true,1,'拥有查看操作日志权限');
-- 角色权限
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(1,1,1001);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(2,1,1002);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(3,1,1003);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(4,1,1004);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(5,1,1005);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(6,1,1006);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(7,1,1007);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(8,1,1008);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(9,1,1009);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(10,1,1010);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(11,1,1011);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(12,1,1012);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(13,1,1013);
INSERT INTO RAC_ROLE_PERM(ID, ROLE_ID, PERM_ID)VALUES(14,1,1014);
-- 菜单
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(1,'platform-admin-web',1001,'/base/rac-domain');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(2,'platform-admin-web',1002,'/base/rac-domain');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(3,'platform-admin-web',1003,'/base/rac-sys');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(4,'platform-admin-web',1004,'/base/rac-sys');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(5,'platform-admin-web',1005,'/base/rac-perm');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(6,'platform-admin-web',1006,'/base/rac-perm');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(7,'platform-admin-web',1007,'/base/rac-role');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(8,'platform-admin-web',1008,'/base/rac-role');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(9,'platform-admin-web',1009,'/account/rac-org');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(10,'platform-admin-web',1010,'/account/rac-org');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(11,'platform-admin-web',1011,'/account/rac-account');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(12,'platform-admin-web',1012,'/account/rac-account');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(13,'platform-admin-web',1013,'/log/lock-log');
INSERT INTO RAC_PERM_MENU(ID, SYS_ID, PERM_ID, MENU_URN)VALUES(14,'platform-admin-web',1014,'/log/op-log');

-- URL
INSERT INTO `RAC_PERM_URN` VALUES 
(875980015911698436,1001,'*:/rac/domain/**'),
(875986330897743872,1002,'GET:/rac/domain/**'),
(875980164188733445,1003,'*:/rac/sys/**'),
(875986401345273857,1004,'GET:/rac/sys/**'),
(875978616129847296,1005,'*:/rac/perm-group/**'),
(875978616280842241,1005,'*:/rac/perm-menu/**'),
(875978616339562498,1005,'*:/rac/perm-urn/**'),
(875978616398282755,1005,'*:/rac/perm/**'),
(875986559676055554,1006,'GET:/rac/perm-group/**'),
(875986559768330243,1006,'GET:/rac/perm-menu/**'),
(875986559818661892,1006,'GET:/rac/perm-urn/**'),
(875986559860604933,1006,'GET:/rac/perm/**'),
(875980626589777926,1007,'*:/rac/role/**'),
(875986649526435846,1008,'GET:/rac/role/**'),
(875982137797509127,1009,'*:/rac/org/**'),
(875986920314896391,1010,'GET:/rac/org/**'),
(875982622923292680,1011,'*:/rac/account/**'),
(875986997913714696,1012,'GET:/rac/account/**'),
(875987052754239497,1013,'GET:/rac/lock-log/**'),
(875987086598078474,1014,'GET:/rac/op-log/**');


