<template>
  <div class="login-page">
    <template v-if="!this.$store.state.isLogin">
      <h1>微博管理登录</h1>
      <el-input placeholder="请输入用户名" v-model="username"></el-input>
      <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
      <el-button type="primary" @click="submit" style="margin-top: 20px;">登陆</el-button>
      <el-button type="primary" @click="registered" style="margin-top: 20px;">注册</el-button>
    </template>
    <template v-else>
      <h1>您好 {{this.$store.state.username}}</h1>
      <el-button type="primary" @click="logout">登出</el-button>
    </template>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    submit () {
      this.$http({
        url: this.$http.adornUrl('/login'),
        method: 'post',
        data: this.$http.adornData({
          'id': 1,
          'name': this.username,
          'pwd': this.password
        })
      }).then(({data}) => {
        if (data && data.code === 201) {
          this.$cookies.set('token', data.token)
          this.$router.replace('/')
          this.$store.state.isLogin = true
          this.$store.state.username = this.username
        } else {
          this.$message.error(data.msg)
        }
      })
    },
    registered () {
      if (this.username && this.password) {
        this.$http({
          url: this.$http.adornUrl('/registered'),
          method: 'post',
          data: this.$http.adornData({
            'id': 1,
            'name': this.username,
            'pwd': this.password
          })
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.$message.info('注册成功')
          } else {
            this.$message.error(data.msg)
          }
        })
      } else {
        this.$message.error('用户名或密码不能为空')
      }
    },
    logout () {
      this.$http({
        url: this.$http.adornUrl('/logout'),
        method: 'post'
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.$cookies.remove('token')
          if (this.$route.path !== '/login') {
            this.$router.replace('/login')
          }
        } else {
          this.$message.error(data.msg)
        }
      })
      this.$store.state.isLogin = false
    }
  }
}
</script>

<style scoped>
.login-page {
  width: 300px;
  height: 160px;
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  justify-content: center;
  align-items: center;
}
</style>
