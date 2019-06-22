package com.hzh.hzhdeno.constans;

/**
 * 系统菜单栏枚举
 * @author wjs
 * @date 2017-6-20 
 *
 */
public enum MenuBars {
	//首页
	HOME("HOME", "首页"),
	//全局规则配置
	GLOBAL_RULE_CONFIG("GLOBAL_RULE_CONFIG", "全局规则配置"),
	CHANLE_RULE_CONFIG("CHAL_RULE_CONFIG", "渠道审核规则配置"),
	ADMISSION_RULE_CONFIG("ADMISSION_RULE_CONFIG", "入场费规则配置"),
	NONCOLLAGE_RULE_CONFIG("NONCOLLAGE_RULE_CONFIG", "非拼团活动收费规则配置"),
	COLLAGE_RULE_CONFIG("COLLAGE_RULE_CONFIG", "拼团活动收费规则配置"),
	RECHARGE_RULE_CONFIG("RECHARGE_RULE_CONFIG", "拼团退费规则配置"),
	FANCE_RULE_CONFIG("FANCE_RULE_CONFIG", "粉丝规则配置"),
	WITHDRAW_RULE_CONFIG("WITHDRAW_RULE_CONFIG", "提现规则配置"),
	ESTIMATE_RULE_CONFIG("ESTIMATE_RULE_CONFIG", "预估费用规则配置"),
	//商家管理
	SHOP_MGR("SHOP_MGR", "商家管理"),
	DEVELOP_SHOP("DEVELOP_SHOP","待开发商家"),
	MIRROR_SHOP("MIRROR_SHOP", "待审核商家"),
	CONFIRM_SHOP("CONFIRM_SHOP", "已认证商家"),
	UNCREATE_SHOP("UNCREATE_SHOP", "为创建门店商家"),
	WIFI_SHOP("WIFI_SHOP","已开通wifi商家"),
	//活动管理
	ACTIVITY_MGR("ACTIVITY_MGR", "活动管理"),
	ACTIVITY("ACTIVITY", "活动管理"),
	ICBC_E("ICBC_E", "ICBC工行融E生活"),
	SHENZHEN_TONG("SHENZHEN_TONG", "深圳通"),
	VERIFY_ACTIVITY("VERIFY_ACTIVITY", "待审核活动"),
	TEMP_ACTIVITY("TEMP_ACTIVITY","高效活动模板配置管理"),
	//卡券管理
	CARD_MANAGER("CARD_MANAGER","卡券管理"),
	TMP_CARD_MANAGER("TMP_CARD_MANAGER","卡券管理"),

	//活动管理
	SOURCE_LABEL("SOURCE_LABEL", "来源标签管理"),
	TRACK_LINK("TRACK_LINK", "跟踪链接管理"),
	//核销管理
	VERIFACATION_MGR("VERIFACATION_MGR", "核销管理"),
	KAQUAN_VERIFY("KAQUAN_VERIFY", "卡券核销"),
	VERIFY_RECORD("VERIFY_RECORD", "核销记录"),
	//物料管理
	MATERIAL_MGR("MATERIAL_MGR", "物料管理"),
	MATERIAL_MANAGER("MATERIAL_MANAGER", "物料管理"),
	MATERIAL_APPROVE("MATERIAL_APPROVE", "物料审批"),
	MATERIAL_BIND("MATERIAL_BIND", "物料绑定"),
	SCALES_MANAGER_INDEX("SCALES_MANAGER_INDEX","体重秤管理"),
	SCALES_ADS("SCALES_ADS","广告图管理"),
	SCALES_DEVICE("SCALES_DEVICE","设备管理"),
	//全员分销管理
	DISTRIBUTION_MANAGER("DISTRIBUTION_MANAGER","分销经理管理"),
	DISTRIBUTION_MEMBER("DISTRIBUTION_MEMBER","分销员"),
	USER_MANAGE("USER_MANAGE","用户管理"),
	APPLY_RECORD("APPLY_RECODE","申请记录"),
	//内容管理
	CONTENT_MGR("CONTENT_MGR", "内容管理"),
	CONTENT_MSG("CONTENT_MSG", "消息管理"),
	CONTENT_TUTORIAL("CONTENT_TUTORIAL", "教程管理"),
	CONTENT_QUESTION("CONTENT_QUESTION", "常见问题管理"),
	CONTENT_TANDIAN("CONTENT_TANDIAN", "探店文章管理"),
	BANNER_CONFIG("BANNER_CONFIG","banner配置"),
	//数据管理
	DATA_MGR("DATA_MGR", "数据管理"),
	REGIST_CERTIFY_DATA("REGIST_CERTIFY_DATA", "注册认证数据"),
	ACT_PUBLISH_DATA("ACT_PUBLISH_DATA", "活动发布数据"),
	ACT_JOIN_DATA("ACT_JOIN_DATA", "活动参与数据"),
	SHOP_DATA("SHOP_DATA", "商家数据"),
	YHB_MINI_DATA("YHB_MINI_DATA", "C端小程序数据"),
	JKB_USAGE_DATA("JKB_USAGE_DATA", "B端程序使用数据"),
	KQ_ACT_CHANEL_DATA("KQ_ACT_CHANEL_DATA", "卡券活动渠道数据"),
	USER_DATA("USER_DATA", "用户数据"),
	COLLAGE_DATA("COLLAGE_DATA", "拼团数据"),
	DISTRIBUTION_DATA("DISTRIBUTION_DATA", "分销数据"),
	NEW_COUNTING_DATA("NEW_COUNTING_DATA", "新统计数据"),
	WIFI_PLAT_DATA("WIFI_PLAT_DATA", "WIFI商家数据"),

	//系统标签管理
	SYS_LABEL_MGR("SYS_LABEL_MGR", "系统标签管理"),
	BUSINESS_LABEL("BUSINESS_LABEL", "商圈标签管理"),
	SHOP_TYPE("SHOP_TYPE", "分类标签管理"),
	LANDMARK_LABEL("LANDMARK_LABEL" , "地标标签管理"),
	//任务管理
	TASK_MGR("TASK_MGR", "任务管理"),
	TAST_MANAGER("TAST_MANAGER", "任务管理"),
	//投申诉管理
	COMPLAINT_MGR("COMPLAINT_MGR", "投申诉管理"),
	COMPLAINT_MANAGER("COMPLAINT_MANAGER", "投诉管理"),
	APPEAL_MANAGER("APPEAL_MANAGER", "申诉管理"),
	//潮级优惠小程序管理
	YHB_MINI_MGR("YHB_MINI_MGR", "潮级优惠小程序管理"),
	HOT_SEARCH("HOT_SEARCH", "热门搜索管理"),
	TOPIC_MANAGER("TOPIC_MANAGER", "合辑主题管理"),
	BANNER_MANAGER("BANNER_MANAGER","首页banner管理"),
	//财务管理
	FINACIAL_MGR("FINACIAL_MGR", "财务管理"),
	INCOME_DATA("INCOME_DATA", "收入数据"),
	RA_RE_WI_DATA("RA_RE_WI_DATA", "充值提现退款数据"),
	WITHDRAW_REQ("WITHDRAW_REQ", "提现申请"),
	WITHDRAW_RECORD("WITHDRAW_RECORD", "提现记录"),
	FULL_STAFF_APPLY("FULL_STAFF_APPLY","全员分销提现申请"),
	RECHARGE_REC("RECHARGE_REC", "充值记录"),
	//组织机构管理
	ORGANIZATION_MANAGE("GROUP","组织机构管理"),
	GROUP("GROUP","机构管理"),
    ROLE("ROLE","角色管理"),
	USER("USER","用户管理"),
	CONFIRM("CONFIRM","充值确定者管理"),
	//买单管理
	BUY_MGR("BUY_MGR", "买单管理"),
	BUY_MANAGER("BUY_MANAGER", "买单管理"),


	CONFIG("CONFIG","系统配置管理"),
	WHITELIST("WHITELIST","白名单管理"),
	APPLET_USER_INDEX("APPLET_USER_INDEX","小程序用户首页"),
	NOTIFY("NOTIFY", "消息管理"),
	ANNOUNCE("ANNOUNCE", "通告管理"),
	//确定者
	SURETY("SURETY", "确定者"),
	PERMISSION("PERMISSION", "权限"),
	PERMISSION_DEMO("PERMISSION_DEMO", "权限demo"),
	TEST("TEST", "测试"),
	FILES_OPERATION("FILES_OPERATION","文件操作"),
    FAST_ENTRANCE("FAST_ENTRANCE", "快速入口管理");

    private String key;
    private String name;
    private MenuBars(String key, String name){
        this.key = key;
        this.name = name;
    }
    public String getKey() {
		return key;
	}
	public String getName() {
		return name;
	}
}
