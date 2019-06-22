package com.hzh.hzhdeno.constans;


/**
 * 创建人 ylb
 * 创建时间 2018-4-25 下午4:01:40
 */
public enum ResultState {
	SUCCESS(1, 0, "成功"),
	AA_SHOP_USER_SCAN_QUCODE(1,374,"二维码已经失效"),
	FAILURE(1, "失败"),
	PARAM_ERROR(2, "参数错误"),
	NO_POWER(3, "无权限访问"),
	STATE_EXCEPTION(4, "状态异常"),
	OPERATION_ERROR(5, "操作错误"),
	REQUEST_ILLEGAL(6, "请求非法"),
	SERVER_ERROR(7, "服务器错误"),
	NO_LOGIN(8, "没有登录"),
	LOGIN_TIME_OUT(9, "登录超时"),
	NO_RESOURCE(10, "访问地址 "),
	NOT_PARENT(11,"父级不存在"),
	NOT_GROUP(12,"机构不存在"),
	GROUP_STATE_EXCEPTION(13,"机构状态异常"),
	PARENT_INFORMATION_FAIL (14,"获取父级信息失败"),
	PARENT_STATE_DISABLE(15,"父级状态为禁用"),
	SUB_LEVELCHANNEL_MANAGERS(16,"子级渠道经理存在库存"),
	NO_NOTICE(17,"未找到公告"),
	NOT_DELETE_PUBLISHED_BULLETIN(18,"不能删除已发布的公告"),
	REFRESH_PAGE_INFORMATION (19,"请刷新页面重新修改个人信息"),
	NOT_NODE(20,"节点不存在"),
	NODE_NOT_LIMIT_IP(21,"节点没有限制IP"),
	ROLE_NOT_EXIST(23,"角色不存在"),
	BOUND_WITH_CONFIRMATIONS(24,"绑定过其他确认者"),
	OPERATION_ABNORMALITY(25,"操作异常"),
	HAVE_BEEN_CANCELLED(26,"已取消"),
	CONNECTION_DROPPED(27,"连接已断开"),
	BOUND_WITH_OTHER_CONFIRMATIONS(28,"绑定过其他确认者"),
	SERVER_INTERNAL_EXCEPTION(29,"服务器内部异常"),
	SCANNING_SUCCESS(0,30,"扫描成功"),
	PERMISSION_EXCEPTION(31,"获取权限异常"),
	PERMISSIONS_NOT(32,"权限不存在"),
	INFORMATION_FAILURE(33,"获取信息失败"),
	USER_BOUND_DETERMINER(34,"用户绑定过确定者"),
	DETERMINER_NOT_EXIST(35,"确定者不存在"),
	SUPER_DETERMINER_NOT_OPERABLE(36,"超级确定者不可操作"),
	LINK_ERROR(37,"链接错误"),
	SYSTEM_ABNORMALITY(38,"系统异常"),
	NOT_DETERMINER(39,"不是确定者"),
	IDENTITY_FORBIDDEN(40,"身份被禁用"),
	LACK_AUTHORITY(41,"权限不足"),
	PERMISSIONS_DISABLED(42,"权限被禁用"),
	DECIDE_ADD_OPERATOR_OPERATION(43,"确定添加操作确定者吗？"),
	DECIDE_UPDATE_OPERATOR_DETERMINER(44,"确定修改确定者的权限吗？"),
	DECIDE_STAT_OPERATOR_DETERMINER(45,"确定启用操作确定者吗？"),
	DECIDE_STOP_OPERATOR_DETERMINER(46,"确定禁用操作确定者吗？"),
	DECIDE_DELETE_OPERATOR_DETERMINER(47,"确定删除操作确定者吗？"),
	FAILURE_INFORMATION_CHECK(48,"信息校验失败"),
	OPERATION_TYPE_EXCEPTION(49,"操作类型异常"),
	CONFIGURATION_NOT_EXIST (50,"配置不存在"),
	VALUE_NOT_EMPTY(51,"值不能为空"),
	NOT_INTEGER(52,"不是整型值"),
	NOT_REGULAR(53,"值不符合正则表达式"),
	NOT_BOOLEAN(54,"不是布尔值"),
	UNKNOWN_ANOMALY(55,"未知异常"),
	NOT_EXIST(56,"节点不存在"),
	NODE_ERROR(57,"节点错误"),
	NODE_WHITE_LIST(58,"节点为白名单"),
	NODE_AVAILABLE_MENUS(59,"节点已存在可用菜单"),
	NOT_MENUS (60,"菜单不存在"),
	EXISTENCE_AVAILABLE_SUBMENUS (61,"存在可用子菜单"),
	ADMINISTRATOR_ONLY_ONE(62,"管理员角色只能有一个"),
	NOT_DELETE_ADMINISTRATOR(63,"不能删除这个系统内置管理员账号"),
	ROLES_CONTAIN_ADMINISTRATOR(64,"角色包含机构管理员角色"),
	WHITE_LIST_NOT_EXIST(65,"白名单不存在"),
	NODE_NON_INTERCEPTED_WHITE_LIST(66,"该节点为不拦截的白名单"),
	NODE_EXISTS_WHITE_LIST(67,"节点存在该白名单"),
	WHITE_LIST_IP_FORMAT_INCORRECT(68,"白名单IP格式不正确"),
	GETTING_NODE_KEY_FAILURE(69,"获取节点KEY失败"),
	NO_SCAN(70, "没有扫描确认"),
	PROJECT_INTERNAL_ANOMALY(71,"项目内部异常"),
	INFORMATION_WRONG(80,"信息有误"),
	WRONG_TOKEN(82, "登录信息失效,请重新登录"),
	EXIST_SYS_USER(83, "系统账户已存在"),
	FAILURE_DATEFORMA(84,"日期格式错误"),
	NO_RESULT(85, "查询无结果"),
	OSS_OPERATE_ERR(86, "OSS参数操作错误"),
	EXCEL_OPERATE_ERR(87, "excel生成失败"),
	VERIFICATION_ERROR(88,"卡券核销状态异常"),
	EXIST_SYS_ROLE(89,"该部门角色已存在"),
	PARAM_ERROR_EMP(90, ""),
	RECORD_EXISTS(91, "记录已存在"),
	SHOP_UPDATE_NEW(92, "错误的镜像"),

	CODE_EXPIRE(100, "抱歉，此卡券已过期！"),
	CODE_REFUND(101, "抱歉，此卡券已退款！"),
	CODE_NOT_TIME(102, "卡券未到使用时间不能用！"),
	CODE_HAS_USED(103, "抱歉，此卡券已被核销！"),
	CREDIT_CODE(104,"税号已存在"),
	PROMOTER_CODE(105,"推广码不存在"),
	CREDITCODE_CHECK_ERROR(107,"该商家已开通WiFi功能，无法重复开通"),
	CHARGE_CONFIRM_SUCCESS(1, 999, "添加充值确认者成功"),
	CHANGE_ADMIN_OPENID(1, 998, "修改管理员微信信息成功");


	private int state;
    private int code;
	private String message;
	
	private ResultState(int code, String message){
		this.code = code;
		this.message = message;
	}
	private ResultState(int state, int code, String message){
		this.state = state;
		this.code = code;
		this.message = message;
	}
	
	public int isState() {
		return state;
	}
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
