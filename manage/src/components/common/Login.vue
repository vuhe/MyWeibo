<template>
  <el-container>
    <el-main class="login-page">
      <h4>微博管理登录</h4>
      <el-input placeholder="请输入密码" v-model="input" show-password></el-input>
      <el-button type="primary" @click="submit">登陆</el-button>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      input: ''
    }
  },
  methods: {
    submit () {
      this.$http({
        url: this.$http.adornUrl('/login'),
        method: 'post',
        data: this.$http.adornData({
          'id': 1,
          'name': 'zhuhe',
          'pwd': this.input
        })
      }).then(({data}) => {
        if (data && data.code === 201) {
          this.$cookies.set('token', data.token)
          this.$router.replace('/')
        } else {
          this.$message.error(data.msg)
        }
      })
    }
  }
}
</script>

<style scoped>
.login-page {
  justify-content: center;
}
</style>
