<template>
  <div>
    <v-row v-for="(item, n) in list"
           :key="n"
           justify="center">
      <v-col class="pt-0 pb-0">
        <v-card
          class="mx-auto"
          elevation="0"
        >
          <v-card-title
            class="mb-3 blue lighten-1 white--text"
          >
            <span class="font-weight-light headline">@ {{ item.user }}</span>
          </v-card-title>

          <v-card-text class="headline font-weight-bold pl-6" v-html="item.content">
          </v-card-text>
          <v-card-actions>
            <v-list-item class="grow">
              <v-list-item-content>
                <v-list-item-title class="headline">
                  <v-icon
                    large
                    left
                  >
                    mdi-update
                  </v-icon>
                  <span class="title font-weight-light">{{ item.time }}</span>
                </v-list-item-title>

              </v-list-item-content>

              <v-row
                align="center"
                justify="end"
              >
                <v-btn
                  outlined
                  rounded
                  @click="likeWeibo(item)"
                >
                  <v-icon class="mr-1">
                    mdi-heart
                  </v-icon>
                  <span class="subheading mr-2">{{ item.like }}</span>
                </v-btn>

              </v-row>
            </v-list-item>
          </v-card-actions>
        </v-card>
<!--        <v-divider class="my-2"></v-divider>-->
      </v-col>
    </v-row>

    <v-row
      align="center"
      justify="center"
    >
      <v-col class="pt-0 pb-0">
        <v-btn
          color="blue lighten-1 white--text title font-weight-light"
          block
          x-large
          @click="loadMore"
          :disabled="btnDisable"
          v-cloak>
          {{btnText}}
        </v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import {contentFormat, socialDateFormat} from '../../utils'

export default {
  name: 'MainContent',
  data () {
    return {
      page: 0,
      list: [],
      btnText: '加载更多',
      btnDisable: false
    }
  },
  created () {
    this.getData(++this.page)
  },
  methods: {
    loadMore () {
      this.getData(++this.page)
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/get/' + page),
        method: 'get'
      }).then(({data}) => {
        if (data && data.code === 200) {
          data.page.records.forEach((i) => {
            let a = {}
            a.id = i.id
            a.content = contentFormat(i.content)
            a.time = socialDateFormat(i.time)
            a.user = i.userName
            a.like = i.likeNum
            this.list.push(a)
          })
          if (data.page.current >= data.page.pages) {
            this.btnText = '已无更多'
            this.btnDisable = true
          }
        }
      })
    },
    likeWeibo (item) {
      this.$http({
        url: this.$http.adornUrl('/like'),
        method: 'put',
        data: item.id
      }).then(({data}) => {
        if (data && data.code === 200) {
          item.like++
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
