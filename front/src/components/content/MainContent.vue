<template>
  <v-container
    class="fill-height"
    fluid
  >

    <v-row v-for="(item, n) in list"
           :key="n"
           justify="center"
           class="ml-5 mr-5 mt-5">
      <v-col xl="8" lg="10" md="9" sm="9" xs="11">
        <v-card
          class="mx-auto"
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

          <v-card-text class="headline font-weight-bold" v-html="item.content">
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>

    <v-row
      class="ma-5"
      max-width="650"
      align="center"
      justify="center"
    >
      <v-col xl="8" lg="10" md="9" sm="9" xs="11">
        <v-btn
          block
          x-large
          @click="loadMore"
          :disabled="btnDisable"
          v-cloak>
          {{btnText}}
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
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
            a.content = contentFormat(i.content)
            a.time = socialDateFormat(i.time)
            this.list.push(a)
          })
          if (data.page.current >= data.page.pages) {
            this.btnText = '已无更多'
            this.btnDisable = true
          }
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
