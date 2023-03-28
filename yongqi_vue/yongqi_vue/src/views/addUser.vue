<template>
    <div class="app">
        <div class="form">
            <el-form ref="userList" :model="userList" label-width="80px"
                     :rules="rules" class="model-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="userList.username"></el-input>
                </el-form-item>
                <el-form-item label="昵称" prop="nickname">
                    <el-input v-model="userList.nickname"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="userList.password"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="userList.phone"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    <el-select v-model="userList.sex" placeholder="请选择性别">
                    <el-option label="男" value="0"></el-option>
                    <el-option label="女" value="1"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="描述" prop="describe">
                    <el-input v-model="userList.describe"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('userList')">提交</el-button>
                    <el-button @click="resetForm('userList')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>
import user from '@/api/user';

  export default {
    data() {
      return {
        // false：添加画面 true：编辑画面
        isEdit: true,
        // 用户信息表单
        userList: {
          username: '',
          nickname: '',
          phone: '',
          sex: '',
          password: '',
          describe: ''
        },
        // 校验规则
        rules: {
            username: [
                { required: true, message: '请输入用户名', trigger: 'blur' },
            ],
            nickname: [
                { required: true, message: '请输入昵称', trigger: 'blur' },
            ],
            password: [
                { required: true, message: '请输入密码', trigger: 'blur' }
            ],
            phone: [
                { required: true, message: '请输入电话', trigger: 'blur' }
            ],
            sex: [
                { required: true, message: '请选择性别', trigger: 'blur' }
            ],
            describe: [
                { required: true, message: '请输入描述', trigger: 'blur' }
            ]
        }
      }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    if (this.isEdit) {
                        // 编辑
                        user.updateUser(this.userList).then(() => {
                            this.$message({
                                type: 'success',
                                message: '更新成功'
                            })
                        })
                    } else {
                        // 添加
                        user.addUser(this.userList).then(() => {
                            this.$message({
                                type: 'success',
                                message: '添加成功'
                            })
                        })
                    }
                    this.$router.push('/')
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        // 判断是添加用户还是编辑用户
        check() {
            if (this.$route.params && this.$route.params.id) {
                // 路径存在id参数，编辑用户
                this.isEdit = true
                user.getUserInfo(this.$route.params.id).then( res => {
                    this.userList = res.data.userInfo
                })
            } else {
                this.isEdit = false
                this.userList = {}
            }
        }
    },
    created() {
        this.check()
    },
    watch: {
        // 监听路由变化
        $route(to, from) {
            this.check()
        }
    }
  }
</script>
<style>
.form {
  width: 50%;
}
/* 清除号码框的上下效果 */
.form input::-webkit-outer-spin-button,
.form input::-webkit-inner-spin-button {
	-webkit-appearance: none;
}

.form input[type='number'] {
	-moz-appearance: textfield;
}
</style>