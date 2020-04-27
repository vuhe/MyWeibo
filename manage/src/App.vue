<template>
  <div id="app">
    <Header></Header>
    <div class="main-page">
      <router-view/>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/header/Header'
import Footer from '@/components/footer/Footer'

export default {
  name: 'App',
  components: {
    Header,
    Footer
  },
  created () {
    this.$store.state.isLogin = this.$store.getters.isLogin
  }
}
</script>

<style>
  html{
    height:100%;
  }
  body{
    min-height:100%;
    margin:0;
    padding:0;
    position:relative;
  }
#app {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
  .main-page {
    position:fixed;
    min-height: calc(100% - 95px);
    line-height: 100%;
    width: 100%;
  }

</style>
