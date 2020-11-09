<template>
  <v-row justify="center">
    <v-col class="pa-0 ma-0">
      <v-card
        class="pa-0 ml-3 mr-3 mx-auto"
        elevation="0"
      >
        <v-card-title
          class="blue lighten-1 mb-3"
        >
          <v-icon
            large
            left
          >
            mdi-note
          </v-icon>
          <span class="title font-weight-light white--text">简介</span>
        </v-card-title>

        <v-card-text class="headline font-weight-bold">
          现在，虽然可以在微博、朋友圈等大把的社交媒体上发表内容。<br>
          但是我们还是希望可以自己有一个没有广告的微博。<br>
          所以这里没有和其它平台一样的广告压力。<br>
          我们希望大家可以在这里找到一个合理的发布渠道<br>
          希望大家能喜欢这个平台。<br>
          <br>
          本平台由 刘龙涛、孙浩然、朱赫 共同开发；<br>
          刘龙涛、孙浩然负责设计界面；朱赫负责实现。
        </v-card-text>
        <v-card-actions>
          <v-list-item class="grow">
            <v-list-item-avatar>
              <v-img
                class="elevation-6"
                src="https://oss.zhuhe.site/weibo/avatar.png"
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
            </v-row>
          </v-list-item>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
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
