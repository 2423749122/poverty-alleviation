const menu = {
	list() {
		return [{
			"backMenu": [{
				"child": [{
					"buttons": ["查看", "删除"],
					"menu": "用户",
					"menuJump": "列表",
					"tableName": "yonghu"
				}],
				"menu": "用户管理"
			},
			// {
			// 	"child": [{
			// 		"buttons": ["查看", "删除", "审核"],
			// 		"menu": "贫困户",
			// 		"menuJump": "列表",
			// 		"tableName": "pinkunhu"
			// 	}],
			// 	"menu": "贫困户管理"
			// },
			{
				"child": [{
					"buttons": ["查看", "修改", "回复", "删除"],
					"menu": "评价管理",
					"tableName": "messages"
				}],
				"menu": "评价管理"
			}, 
			{
				"child": [
					{
					"buttons": ['新增',"查看", "修改",  "删除"],
					"menu": "项目管理",
					"tableName": "project"
				},
				{
					"buttons": ['新增',"查看", "修改",  "删除"],
					"menu": "方案管理",
					"tableName": "fangan"
				},
				{
					"buttons": ["查看", "删除", "审核"],
					"menu": "贫困户",
					"menuJump": "列表",
					"tableName": "pinkunhu"
				}
				],
				"menu": "信息公示"
			}, 
			// {
			// 	"child": [{
			// 		"buttons": ['新增',"查看", "修改",  "删除"],
			// 		"menu": "方案管理",
			// 		"tableName": "fangan"
			// 	}],
			// 	"menu": "方案管理"
			// }, 
			// {
			// 	"child": [{
			// 		"buttons": ['新增',"查看", "修改",  "删除"],
			// 		"menu": "热门新闻列表",
			// 		"menuJump": "列表",
			// 		"tableName": "remenxinwen"
			// 	}],
			// 	"menu": "热门新闻模块"
			// }, 
			{
				"child": [{
					"buttons": ["查看", "修改"],
					"menu": "轮播图管理",
					"tableName": "config"
				}],
				"menu": "系统管理"
			}],
			"frontMenu": [{
				"child": [{
					"buttons": ["查看"],
					"menu": "贫困户列表",
					"menuJump": "列表",
					"tableName": "pinkunhu"
				}],
				"menu": "贫困户模块"
			}],
			"hasBackLogin": "是",
			"hasBackRegister": "否",
			"hasFrontLogin": "否",
			"hasFrontRegister": "否",
			"roleName": "管理员",
			"tableName": "users"
		}, {
			"backMenu": [
				{
				"child": [
					{
					"buttons": [ "查看"],
					"menu": "项目公示",
					"tableName": "project"
				},
				{
					"buttons": [ "查看"],
					"menu": "扶贫对象公示",
					"menuJump": "列表",
					"tableName": "pinkunhu2"
				},
				{
					"buttons": [ "查看"],
					"menu": "扶贫方案公示",
					"menuJump": "列表",
					"tableName": "fangan"
				}
				],
				"menu": "信息公示"
			},
			{
				"child": [{
					"buttons": ['新增',"查看", "修改",  "删除"],
					"menu": "贫困户",
					"tableName": "pinkunhu"
				}],
				"menu": "贫困户管理"
			},
			
			],
			"hasBackLogin": "是",
			"hasBackRegister": "是",
			"hasFrontLogin": "是",
			"hasFrontRegister": "是",
			"roleName": "用户",
			"tableName": "yonghu"
		}]
	}
}
export default menu;
