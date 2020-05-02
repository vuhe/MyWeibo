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
            2020年，可以在微博、朋友圈等大把的社交媒体上发表内容。<br>
            我一定是在逃避什么，才搭了这玩意。<br>
            所以这里没有点赞评论、 阅读量以及随之而来的社交压力。<br>
            我也不关心你多久会点开与忘记这个站点<br>
            因为它的全部意义就在于迎合我自己。
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
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'InfoContent'
}
</script>

<style scoped>

</style>
