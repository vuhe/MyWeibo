<template>
  <div class="header-page">
    <el-menu
      style="padding-left: 50px;"
      router
      :default-active="this.$route.path"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="/login">用户页</el-menu-item>
      <el-menu-item index="/" :disabled="!this.$store.state.isLogin">主要管理页</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
.header-page {
  padding: 0;
}
</style>
