<template>
  <v-container
    class="fill-height"
    fluid
  >
    <v-row justify="center" class="ma-5">
      <v-col xl="8" lg="10" md="9" sm="9" xs="11">
        <v-card
          class="mx-auto"
        >
          <v-card-title>
            <v-icon
              large
              left
            >
              mdi-note
            </v-icon>
            <span class="title font-weight-light">简介</span>
          </v-card-title>

          <v-card-text class="headline font-weight-bold">
            现在，虽然可以在微博、朋友圈等大把的社交媒体上发表内容。<br>
            但是我们还是希望可以自己有一个没有广告的微博。<br>
            所以这里没有和其它平台一样的广告压力。<br>
            我们希望大家可以在这里找到一个合理的发布渠道<br>
            希望大家能喜欢这个平台。
          </v-card-text>
          <v-card-actions>
            <v-list-item class="grow">
              <v-list-item-avatar>
                <v-img
                  class="elevation-6"
                  src="https://oss.zhuhe.site/weibo/icon.png"
                ></v-img>
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>vuhe(Zhu He)</v-list-item-title>
              </v-list-item-content>

              <v-row
                align="center"
                justify="end"
              >
                <span class="subheading">截止目前共计 {{total}} 条</span>
                <v-btn
                  class="ml-3"
                  outlined
                  rounded
                  href="https://weibo.zhuhe.site/manage"
                  target="_blank"
                >
                  管理微博
                </v-btn>
              </v-row>
            </v-list-item>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'InfoContent',
  data () {
    return {
      total: 0
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.$http({
        url: this.$http.adornUrl('/get/1'),
        method: 'get'
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.total = data.page.total
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
