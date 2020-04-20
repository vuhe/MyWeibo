<template>
  <v-content>
    <v-container
      class="fill-height"
      fluid
    >
      <v-row class="ml-5 mr-5 mb-5">
        <v-card
          class="mx-auto"
          color="light-blue lighten-3"
          max-width="650"
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
            2020年，可以在微博、朋友圈等发表内容。我一定是在逃避什么，才搭了这玩意。所以这里没有点赞评论、
            阅读量以及随之而来的社交压力，我也不关心你多久会点开与忘记这个站点，因为它的全部意义就在于迎合我自己。
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
                <span class="subheading">截止目前共计 30 条</span>
              </v-row>
            </v-list-item>
          </v-card-actions>
        </v-card>
      </v-row>

      <v-row v-for="(item, n) in list"
             :key="n"
             class="ml-5 mr-5 mb-5">
        <v-card
          class="mx-auto"
          color="cyan lighten-3"
          max-width="650"
        >
          <v-card-title>
            <v-icon
              large
              left
            >
              mdi-update
            </v-icon>
            <span class="title font-weight-light">{{ item.time }}</span>
          </v-card-title>

          <v-card-text class="headline font-weight-bold">
            {{ item.text }}
          </v-card-text>
        </v-card>
      </v-row>

      <v-row
        class="ma-5"
        max-width="650"
        align="center"
        justify="center"
      >
        <v-btn
          x-large
          color="green lighten-2"
          @click="loadMore"
          :disabled="btnDisable"
          v-cloak>
          {{btnText}}
        </v-btn>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
export default {
  name: 'MainContent',
  data () {
    return {
      page: 0,
      list: [],
      btnText: '加载更多',
      btnDisable: false,
    }
  },
  methods: {
    loadMore: function (event) {
      this.getData(++this.page)
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/get/' + page),
        method: 'get'
      }).then(({data}) => {
        if (data && data.code === 200) {
          if (data.length <= 0) {
            this.btnText = '已无更多'
            this.btnDisable = true
          } else {
            data.list.forEach((i) => {
              // 日期的传输暂未确定
              this.list.push(i)
            })
          }
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
