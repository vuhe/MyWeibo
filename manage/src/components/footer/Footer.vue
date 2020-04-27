<template>
  <div class="footer-page" style="color: #909399;">
    <el-col>
      <a class="footer-link" href="http://beian.miit.gov.cn/" target="_blank">
        豫ICP备19043858号
      </a>
      <span>|</span>
      版权所有 © {{ copy_year }}
    </el-col>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data () {
    return {
      copy_year: '',
      page: 1
    }
  },
  created () {
    let date = new Date()
    this.copy_year = date.getFullYear()
  }
}
</script>

<style scoped>
  .footer-page {
    justify-content: center;
    position:absolute;
    bottom:0;
    width:100%;
    height: 30px;
  }
  .footer-link {
    text-decoration: none;
    color: #909399;
  }
</style>
