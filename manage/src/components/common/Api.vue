<template>
  <iframe
    id="api"
    frameborder="no"
    class="api-page"
    :src="url">
  </iframe>
</template>

<script>
export default {
  name: 'Api',
  data () {
    return {
      url: ''
    }
  },
  created () {
    this.url = this.$http.adornUrl('/swagger-ui.html')
  },
  mounted () {
    this.getTableHeight()
  },
  methods: {
    getTableHeight () {
      let dataHeight = document.getElementById('main').clientHeight
      document.getElementById('api').style.height = dataHeight + 'px'
    }
  }
}
</script>

<style scoped>
.api-page {
  width: 100%;
}
</style>
