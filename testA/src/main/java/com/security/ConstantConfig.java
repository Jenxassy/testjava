package com.security;

/**
 * @描述 : 常量定义
 * @创建人 zyh
 * @创建时间 2018/4/20
 */
public enum ConstantConfig {

    /**
     * 查询前台日志失败
     */
    SELECT_FRONTLOG_ERROR(600, "查询前台日志失败"),

    /**
     * @描述 查询前台日志失败
     * @创建人 zyh
     * @创建时间 2018/4/20
     */
    SELECT_BACKLOG_ERROR(601, "查询后台日志失败"),

    /**
     * @描述 会员查询订单失败
     * @创建人 zyh
     * @创建时间 2018/4/21
     */
    SELECT_COMPANY_ORDER_ERROR(602, "会员查询订单失败"),

    /**
     * @描述 会员新增订单失败
     * @创建人 zyh
     * @创建时间 2018/4/23
     */
    ADD_COMPANY_ORDER_ERROR(603, "会员新增订单失败"),

    /**
     * @描述 会员查询订单详情失败
     * @创建人 zyh
     * @创建时间 2018/4/23
     */
    SELECT_COMPANY_ORDER_BY_ID_ERROR(604, "会员查询订单详情失败"),

    /**
     * @描述 修改评价失败
     * @创建人 zyh
     * @创建时间 2018/4/25
     */
    UPDATE_ASSESS_BY_ID_ERROR(605, "会员修改评价失败"),

    /**
     * @描述 查询子订单失败
     * @创建人 zyh
     * @创建时间 2018/4/26
     */
    SELECT_SUBORDER_ERROR(606, "查询子订单失败"),

    /**
     * @描述 修改用户姓名失败
     * @创建人 zyh
     * @创建时间 2018/4/26
     */
    UPDATE_USERNAME_ERROR(607, "修改用户姓名失败"),


    /**
     * @描述 旧密码不一致
     * @创建人 zyh
     * @创建时间 2018/4/26
     */
    UPDATE_OLDPASSWORD_ERROR(608, "修改密码失败,原密码错误"),

    /**
     * @描述 修改密码失败
     * @创建人 zyh
     * @创建时间 2018/4/26
     */
    UPDATE_PASSWORD_ERROR(609, "修改密码失败,系统错误"),

    /**
     * @描述 新增操作员失败
     * @创建人 zyh
     * @创建时间 2018/4/28
     */
    ADD_OPERATOR_ERROR(610, "新增操作员失败"),

    /**
     * @描述 修改操作员信息失败
     * @创建人 zyh
     * @创建时间 2018/4/28
     */
    UPDATE_OPERATOR_ERROR(611, "修改操作员信息失败"),

    /**
     * @描述 删除操作员失败
     * @创建人 zyh
     * @创建时间 2018/4/28
     */
    DELETE_OPERATOR_ERROR(612, "删除操作员失败"),

    /**
     * @描述 查询订单数量状态失败
     * @创建人 zyh
     * @创建时间 2018/5/2
     */
    SELECT_COMPANY_ORDER_SUM_ERROR(613, "查询订单数量状态失败"),

    /**
     * @描述 查询操作员列表失败
     * @创建人 zyh
     * @创建时间 2018/5/2
     */
    SELECT_OPERATOR_ERROR(614, "查询操作员列表失败"),

    /**
     * @描述 查询操作员详情失败
     * @创建人 zyh
     * @创建时间 2018/5/2
     */
    SELECT_OPERATOR_BY_ID_ERROR(615, "查询操作员详情失败"),

    /**
     *@描述  新增后台账号失败
     *@创建人  zyh
     *@创建时间  2018/5/9
     */
    ADD_BACK_USER_ERROR(616, "新增后台账号失败"),

    /**
     *@描述 注销后台账号失败
     *@创建人  zyh
     *@创建时间  2018/5/9
     */
    DELETE_BACK_USER_ERROR(617, "注销后台账号失败"),

    /**
     *@描述 修改后台账号失败
     *@创建人  zyh
     *@创建时间  2018/5/9
     */
    UPDATE_BACK_USER_ERROR(618, "修改后台账号失败"),

    /**
     *@描述 查询后台账号失败
     *@创建人  zyh
     *@创建时间  2018/5/10
     */
    SELECT_BACK_USER_ERROR(619, "查询后台账号失败"),

    /**
     *@描述 查询销售员失败
     *@创建人  zyh
     *@创建时间  2018/5/10
     */
    SELECT_SALERS_ERROR(620, "查询销售员失败"),

    /**
     *@描述 查询代购员失败
     *@创建人  zyh
     *@创建时间  2018/5/10
     */
    SELECT_PURCHASER_ERROR(621, "查询代购员失败"),

    /**
     *@描述 新增会员账号失败
     *@创建人  zyh
     *@创建时间  2018/5/10
     */
    ADD_COMPANY_USER_ERROR(622, "新增会员账号失败"),

    /**
     *@描述 修改会员账号信息失败
     *@创建人  zyh
     *@创建时间  2018/5/10
     */
    UPDATE_COMPANY_USER_ERROR(623, "修改会员账号信息失败"),

    /**
     *@描述 查询会员账号详情失败
     *@创建人  zyh
     *@创建时间  2018/5/11
     */
    SELECT_COMPANY_USER_BY_ID_ERROR(624, "查询会员账号详情失败"),

    /**
     *@描述 查询会员账号失败
     *@创建人  zyh
     *@创建时间  2018/5/12
     */
    SELECT_COMPANY_USER_ERROR(625, "查询会员账号失败"),

    /**
     *@描述 查询操作员失败(下拉框)
     *@创建人  zyh
     *@创建时间  2018/5/14
     */
    SELECT_ORDER_ERROR(626, "查询操作员失败"),

    /**
     *@描述 查询后台订单失败
     *@创建人  zyh
     *@创建时间  2018/5/14
     */
    SELECT_BACK_ORDER_ERROR(627, "查询后台订单失败"),

    /**
     *@描述 修改买家账号有效值失败
     *@创建人  zyh
     *@创建时间  2018/5/15
     */
    UPDATE_BUYER_ACCOUNT_ERROR(628, "修改买家账号有效值失败"),

    /**
     *@描述 修改子订单订单编号失败
     *@创建人  zyh
     *@创建时间  2018/5/15
     */
    UPDATE_NUMBER_ERROR(629, "修改子订单订单编号失败"),

    /**
     *@描述 修改评价失败
     *@创建人  zyh
     *@创建时间  2018/5/15
     */
    UPDATE_ACCESS_ERROR(630, "修改评价失败"),

    /**
     *@描述 后台查看订单详情失败
     *@创建人  zyh
     *@创建时间  2018/5/16
     */
    SELECT_BACK_ORDER_BY_ID_ERROR(631, "查看订单详情失败"),

    /**
     *@描述 查询会员失败
     *@创建人  zyh
     *@创建时间  2018/5/16
     */
    SELECT_COMPANY_ERROR(632, "查询会员失败"),

    /**
     *@描述 查看子订单详情失败
     *@创建人  zyh
     *@创建时间  2018/5/18
     */
    SELECT_SUBORDER_BY_ID_ERROR(633, "查看子订单详情失败"),

	/**
	 *@描述 指派跟卖订单失败
	 *@创建人  zyh
	 *@创建时间  2018/5/23
	 */
	ASSIGN_SALE_ORDER_ERROR(634,"指派跟卖订单失败"),

	/**
	 *@描述 会员查询资料失败
	 *@创建人  zyh
	 *@创建时间  2018/5/24
	 */
	SELECT_COMPANY_DATA_ERROR(635, "会员查询资料失败"),

	/**
	 *@描述  添加跟卖表示失败
	 *@创建人  zyh
	 *@创建时间  2018/5/24
	 */
	UPDATE_MARKING_ERROR(636, "添加跟卖表示失败"),

	/**
	 *@描述 查看首页失败
	 *@创建人  zyh
	 *@创建时间  2018/5/24
	 */
	SELECT_BACK_HOME_SUM_ERROR(637, "查看首页失败"),

    /**
     *@描述 获取token失败
     *@创建人  zyh
     *@创建时间  2018/5/8
     */
    SELECT_OAUTH2_ERROR(998, "获取token失败"),

    /**
     *@描述 非正确的客户端
     *@创建人  zyh
     *@创建时间  2018/5/8
     */
    SELECT_OAUTH2_CLIENT_ERROR(997, "非正确的客户端"),

    /**
     *@描述 登录前判断该角色没有权限
     *@创建人  zyh
     *@创建时间  2018/5/8
     */
    SELECT_OAUTH2_DENIED_ERROR(996, "没有该权限"),

    /**
     *@描述 登录后判断该角色没有权限
     *@创建人  zyh
     *@创建时间  2018/5/8
     */
    SELECT_OAUTH2_NORIGHT_ERROR(999, "该角色没有权限"),
    
    /**
     * 根据状态查询邮箱域名失败
     * @author cai
     * @date 2018/5/18
     */
    SELECT_DOMAIN_ERROR(222, "根据状态查询邮箱域名失败"),
    
    /**
     * 新增邮箱域名失败
     * @author cai
     * @date 2018/5/18
     */
    ADD_DOMAIN_ERROR(223, "新增邮箱域名失败"),
	
    /**
     * 编辑邮箱域名失败
     * @author cai
     * @date 2018/5/18
     */
	UPDATE_DOMAIN_ERROR(224, "编辑邮箱域名失败"),
	
	/**
	 * 删除邮箱域名失败
	 * @author cai
     * @date 2018/5/18
	 */
	DELETE_DOMAIN_ERROR(225, "删除邮箱域名失败"),
	
	/**
	 * 根据状态查询邮箱失败
	 * @author cai
     * @date 2018/5/18
	 */
	SELECT_EMAIL_ERROR(226, "根据状态查询邮箱失败"),
	
	/**
	 * 批量新增邮箱失败
	 * @author cai
     * @date 2018/5/18
	 */
	ADD_EMAIL_ERROR(227, "批量新增邮箱失败"),
	
	/**
	 * Excel批量导出邮箱失败
	 * @author cai
     * @date 2018/5/18
	 */
	EXPORT_EMAIL_ERROR(228, "Excel批量导出邮箱失败"),
	
	/**
	 * 查找使用中的邮箱域名失败
	 * @author cai
     * @date 2018/5/18
	 */
	FIND_DOMAIN_ERROR(229, "查找使用中的邮箱域名失败"),
	
	/**
	 * 根据条件查询礼品卡失败
	 * @author cai
     * @date 2018/5/18
	 */
	SELECT_GIFT_ERROR(230, "根据条件查询礼品卡失败"),
	
	/**
	 * 新增礼品卡失败
	 * @author cai
     * @date 2018/5/18
	 */
	ADD_GIFT_ERROR(231, "新增礼品卡失败"),
	
	/**
	 * 批量新增礼品卡失败
	 * @author cai
     * @date 2018/5/18
	 */
	BATCH_ADD_GIFT_ERROR(232, "批量新增礼品卡失败"),
	
	/**
	 * 根据使用次数查询IP失败
	 * @author cai
     * @date 2018/5/18
	 */
	FIND_IP_ERROR(233, "根据使用次数查询IP失败"),
	
	/**
	 * 新增IP失败
	 * @author cai
     * @date 2018/5/21
	 */
	ADD_IP_ERROR(234, "新增IP失败"),
	
	/**
	 * 批量新增IP失败
	 * @author cai
     * @date 2018/5/21
	 */
	BATCH_IP_ERROR(235, "批量新增IP失败"),
	
	/**
	 * 删除IP失败
	 * @author cai
     * @date 2018/5/21
	 */
	DEL_IP_ERROR(236, "删除IP失败"),
	
	/**
	 * 根据状态查询用户信息失败
	 * @author cai
     * @date 2018/5/21
	 */
	FIND_INFO_ERROR(237, "根据状态查询用户信息失败"),
	
	/**
	 * 批量生成用户信息失败
	 * @author cai
     * @date 2018/5/21
	 */
	BATCH_INFO_ERROR(238, "批量添加用户信息失败"),
	
	/**
	 * 删除用户失败
	 * @author cai
     * @date 2018/5/21
	 */
	DEL_Info_ERROR(239, "删除用户失败"),
	
	/**
	 * 新增买家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	ADD_BUYER_ERROR(240, "新增买家账号失败"),
	
	/**
	 * 批量新增买家账号
	 * @author cai
     * @date 2018/5/21
	 */
	BATCH_BUYER_ERROR(241, "批量新增买家账号失败"),
	
	/**
	 * 修改买家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	MODIFY_BUYER_ERROR(242, "修改买家账号失败"),
	
	/**
	 * 根据条件查询买家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	FIND_BUYERS_ERROR(243, "根据条件查询买家账号失败"),
	
	/**
	 * 新增卖家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	ADD_SELLER_ERROR(244, "新增卖家账号失败"),
	
	/**
	 * 批量新增卖家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	BATCH_SELLER_ERROR(245, "批量新增卖家账号失败"),
	
	/**
	 * 修改卖家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	MODIFY_SELLER_ERROR(246, "修改卖家账号失败"),
	
	/**
	 * 根据条件查询卖家账号失败
	 * @author cai
     * @date 2018/5/21
	 */
	FIND_SELLERS_ERROR(247, "根据条件查询卖家账号失败"),
	
	/**
	 * 抓取商品数据失败
	 * @author cai
     * @date 2018/5/23
	 */
	FETCH_PRODUCT_ERROR(248, "抓取商品数据失败"),
	
	/**
	 * 批量导出子订单信息失败
	 * @author cai
     * @date 2018/5/25
	 */
	EXPORT_SUBORDER_ERROR(249, "批量导出子订单信息失败"),
	
	/**
	 * 批量导出子订单评价信息失败
	 * @author cai
     * @date 2018/5/25
	 */
	EXPORT_ASSESS_ERROR(250, "批量导出子订单评价信息失败"),
	
	/**
	 * 查询买家注册信息失败
	 * @author cai
     * @date 2018/5/25
	 */
	FIND_BUYERREGISTET_ERROR(251, "查询买家注册信息失败"),
	
	/**
	 * 查询可生成的邮箱数量、IP数量、用户信息数量失败
	 * @author cai
     * @date 2018/5/25
	 */
	FIND_ALLNUM_ERROR(252, "查询可生成的邮箱数量、IP数量、用户信息数量失败"),
	
	/**
	 * 导出买家注册信息失败
	 * @author cai
     * @date 2018/5/25
	 */
	EXPORT_BUYERINFO_ERROR(253, "导出买家注册信息失败"),
	
	/**
	 * 根据id查询买家账号详情信息失败
	 * @author cai
     * @date 2018/5/25
	 */
	FIND_BUYERINFO_ERROR(254, "根据id查询买家账号详情信息失败"),
	
	/**
	 * 根据id查询卖家账号详情信息
	 * @author cai
     * @date 2018/5/25
	 */
	FIND_SELLERINFO_ERROR(255, "根据id查询卖家账号详情信息失败");
	
    public int code;
    public String text;

    ConstantConfig(int code, String text) {
        this.code = code;
        this.text = text;
    }

}
