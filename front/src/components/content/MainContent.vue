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
          <v-card-actions>
            <v-list-item class="grow">
              <v-list-item-avatar color="grey darken-3">
                <v-img
                  class="elevation-6"
                  alt=""
                  src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortCurly&accessoriesType=Prescription02&hairColor=Black&facialHairType=Blank&clotheType=Hoodie&clotheColor=White&eyeType=Default&eyebrowType=DefaultNatural&mouthType=Default&skinColor=Light"
                ></v-img>
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>{{ item.user }}</v-list-item-title>
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
