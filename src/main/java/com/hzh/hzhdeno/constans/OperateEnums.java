package com.hzh.hzhdeno.constans;



/**
 * 定义菜单栏的操作权限
 *
 * @author wjs
 * @date 2017-6-20
 *
 */
public enum OperateEnums {
	//首页
	HOME_INDEX(MenuBars.HOME,"INDEX", "首页"),
	//全局规则配置
	CHANLE_RULE_INDEX(MenuBars.CHANLE_RULE_CONFIG,"INDEX", "渠道审核规则配置"),
	ADMISSION_RULE_INDEX(MenuBars.ADMISSION_RULE_CONFIG, "INDEX","入场费规则配置"),
	NONCOLLAGE_RULE_INDEX(MenuBars.NONCOLLAGE_RULE_CONFIG,"INDEX", "非拼团活动收费规则配置"),
	COLLAGE_RULE_INDEX(MenuBars.COLLAGE_RULE_CONFIG,"INDEX", "拼团活动收费规则配置"),
	RECHARGE_RULE_INDEX(MenuBars.RECHARGE_RULE_CONFIG,"INDEX", "拼团退费规则配置"),
	FANCE_RULE_INDEX(MenuBars.FANCE_RULE_CONFIG,"INDEX", "粉丝规则配置"),
	WITHDRAW_RULE_INDEX(MenuBars.WITHDRAW_RULE_CONFIG,"INDEX", "提现规则配置"),
	ESTIMATE_RULE_INDEX(MenuBars.ESTIMATE_RULE_CONFIG,"INDEX", "预估费用规则配置"),
	//商家管理
	DEVELOP_SHOP_INDEX(MenuBars.DEVELOP_SHOP,"INDEX","待开发商家"),
	MIRROR_SHOP_INDEX(MenuBars.MIRROR_SHOP,"INDEX", "待审核商家"),
	CONFIRM_SHOP_INDEX(MenuBars.CONFIRM_SHOP,"INDEX", "已认证商家"),
	UNCREATE_SHOP_INDEX(MenuBars.UNCREATE_SHOP,"INDEX", "为创建门店商家"),
	WIFI_SHOP_INDEX(MenuBars.WIFI_SHOP,"INDEX", "已开通wifi商家"),
	//活动管理
	ACTIVITY(MenuBars.ACTIVITY,"INDEX", "活动管理"),
	ICBC_E(MenuBars.ICBC_E,"INDEX", "工行融e生活活动"),
	SHENZHEN_TONG(MenuBars.SHENZHEN_TONG,"INDEX", "深圳通"),
	VERIFY_ACTIVITY(MenuBars.VERIFY_ACTIVITY,"INDEX", "待审核活动"),
	TEMP_ACTIVITY(MenuBars.TEMP_ACTIVITY,"INDEX","高效活动模板配置管理"),

	//卡券管理
	TEMP_CARD_MANAGER(MenuBars.TMP_CARD_MANAGER,"INDEX","卡券管理"),

	//来源跟踪管理
	SOURCE_LABEL(MenuBars.SOURCE_LABEL,"INDEX", "来源标签管理"),
	TRACK_LINK(MenuBars.TRACK_LINK,"INDEX", "跟踪链接管理"),
	//核销管理
	KAQUAN_VERIFY_INDEX(MenuBars.KAQUAN_VERIFY,"INDEX", "卡券核销"),
	VERIFY_RECORD_INDEX(MenuBars.VERIFY_RECORD,"INDEX", "核销记录"),
	//物料管理
	MATERIAL_MANAGER_INDEX(MenuBars.MATERIAL_MANAGER,"INDEX", "物料管理"),
	MATERIAL_APPROVE_INDEX(MenuBars.MATERIAL_APPROVE,"INDEX", "物料审批"),
	MATERIAL_BIND_INDEX(MenuBars.MATERIAL_BIND,"INDEX", "物料绑定"),
	// 全员分销管理
	DISTRIBUTION_MANAGER_INDEX(MenuBars.DISTRIBUTION_MANAGER,"INDEX","分销经理管理"),
    DISTRIBUTION_MEMBER_INDEX(MenuBars.DISTRIBUTION_MEMBER,"INDEX","分销员" ),
	USER_MANAGE_INDEX(MenuBars.USER_MANAGE,"INDEX","用户管理"),
    APPLY_RECORD_INDEX(MenuBars.APPLY_RECORD,"INDEX","申请记录"),
	//体重秤管理
	SCALES_ADS(MenuBars.SCALES_ADS,"INDEX","广告图管理"),
	SCALES_DEVICE(MenuBars.SCALES_DEVICE,"INDEX","设备管理"),

	//内容管理
	CONTENT_MSG_INDEX(MenuBars.CONTENT_MSG,"INDEX", "消息管理"),
	CONTENT_TUTORIAL_INDEX(MenuBars.CONTENT_TUTORIAL,"INDEX", "教程管理"),
	CONTENT_QUESTION_INDEX(MenuBars.CONTENT_QUESTION,"INDEX", "常见问题管理"),
	CONTENT_TANDIAN_INDEX(MenuBars.CONTENT_TANDIAN,"INDEX", "探店文章管理"),
	BANNER_CONFIG_INDEX(MenuBars.BANNER_CONFIG,"INDEX","banner配置"),
	//数据管理
	REGIST_CERTIFY_DATA_INDEX(MenuBars.REGIST_CERTIFY_DATA,"INDEX", "注册认证数据"),
	ACT_PUBLISH_DATA_INDEX(MenuBars.ACT_PUBLISH_DATA,"INDEX", "活动发布数据"),
	ACT_JOIN_DATA_INDEX(MenuBars.ACT_JOIN_DATA,"INDEX", "活动参与数据"),
	SHOP_DATA_INDEX(MenuBars.SHOP_DATA,"INDEX", "商家数据"),
	YHB_MINI_DATA_INDEX(MenuBars.YHB_MINI_DATA,"INDEX", "C端小程序数据"),
	JKB_USAGE_DATA_INDEX(MenuBars.JKB_USAGE_DATA,"INDEX", "B端程序使用数据"),
	KQ_ACT_CHANEL_DATA_INDEX(MenuBars.KQ_ACT_CHANEL_DATA,"INDEX", "卡券活动渠道数据"),
	USER_DATA_INDEX(MenuBars.USER_DATA,"INDEX", "用户数据"),
	COLLAGE_DATA_INDEX(MenuBars.COLLAGE_DATA,"INDEX", "拼团数据"),
	DISTRIBUTION_DATA_INDEX(MenuBars.DISTRIBUTION_DATA,"INDEX", "分销数据"),
	NEW_COUNTING_DATA_INDEX(MenuBars.NEW_COUNTING_DATA,"INDEX", "新统计数据"),
	WIFI_PLAT_INDEX(MenuBars.WIFI_PLAT_DATA,"INDEX", "wifi商家数据"),

	//系统标签管理
	BUSINESS_LABEL_INDEX(MenuBars.BUSINESS_LABEL,"INDEX", "商圈标签管理"),
	SHOP_TYPE_INDEX(MenuBars.SHOP_TYPE,"INDEX", "分类标签管理"),
	LANDMARK_LABEL_INDEX(MenuBars.LANDMARK_LABEL,"INDEX","地标标签管理"),
	//任务管理
	TAST_MANAGER_INDEX(MenuBars.TAST_MANAGER,"INDEX", "任务管理"),
	//投申诉管理
	COMPLAINT_MANAGER_INDEX(MenuBars.COMPLAINT_MANAGER,"INDEX", "投诉管理"),
	APPEAL_MANAGER_INDEX(MenuBars.APPEAL_MANAGER,"INDEX", "申诉管理"),
	//潮级优惠小程序管理
	HOT_SEARCH_INDEX(MenuBars.HOT_SEARCH,"INDEX", "热门搜索管理"),
	TOPIC_MANAGER_INDEX(MenuBars.TOPIC_MANAGER,"INDEX", "合辑主题管理"),
	BANNER_MANAGER_INDEX(MenuBars.BANNER_MANAGER,"INDEX","首页banner管理"),
	//财务管理
	INCOME_DATA_INDEX(MenuBars.INCOME_DATA,"INDEX", "收入数据"),
	RA_RE_WI_DATA_INDEX(MenuBars.RA_RE_WI_DATA,"INDEX", "充值提现退款数据"),
	WITHDRAW_REQ_INDEX(MenuBars.WITHDRAW_REQ,"INDEX", "提现申请"),
	WITHDRAW_RECORD_INDEX(MenuBars.WITHDRAW_RECORD,"INDEX", "提现记录"),
	RECHARGE_REC_INDEX(MenuBars.RECHARGE_REC,"INDEX", "充值记录"),
	FULL_STAFF_APPLY_INDEX(MenuBars.FULL_STAFF_APPLY,"INDEX", "全员分销提现申请"),
	//组织机构管理
	GROUP_INDEX(MenuBars.GROUP,"INDEX","机构管理"),
	USER_INDEX(MenuBars.USER,"INDEX","用户管理"),
	ROLE_INDEX(MenuBars.ROLE,"INDEX","角色管理"),
	CONFIRM_INDEX(MenuBars.CONFIRM,"INDEX","菜单管理"),
	//买单管理
	BUY_MANAGER_INDEX(MenuBars.BUY_MANAGER,"INDEX", "买单管理"),
	// 快速入口
	FAST_ENTRANCE_INDEX(MenuBars.FAST_ENTRANCE, "INDEX","快速入口管理" );
    /**
	 *
	 */
    private MenuBars menuBar;
    private String key;
    private String name;
    private OperateEnums(MenuBars menuBar, String key, String name){
    	this.menuBar = menuBar;
        this.key = key;
        this.name = name;
    }
	public MenuBars getMenuBar() {
		return menuBar;
	}
	public String getKey() {
		return key;
	}
	public String getName() {
		return name;
	}


}
