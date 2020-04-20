<template>
  <v-footer
    absolute
    padless
    color="indigo"
    app
  >
    <v-col
      class="text-center grey lighten-5 blue-grey--text"
      cols="12"
    >
      <a class="blue-grey--text" href="http://beian.miit.gov.cn/" target="_blank">
        豫ICP备19043858号
      </a>
      <span>|</span>
      版权所有 © {{ copy_year }}
    </v-col>
  </v-footer>
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
</style>
