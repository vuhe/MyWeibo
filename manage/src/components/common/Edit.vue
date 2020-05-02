<template>
    <div class="edit-page">
      <el-page-header @back="goBack" content="写微博" style="margin: 10px">
      </el-page-header>
      <el-card>
        <div slot="header">
          <span>{{hint}}</span>
          <el-button
            style="float: right; padding: 3px 0"
            type="text"
            @click="submit">提交</el-button>
        </div>
        <el-input
          type="textarea"
          :autosize="{ minRows: 10, maxRows: 20}"
          placeholder="说点什么吧"
          v-model="content">
        </el-input>
      </el-card>
    </div>
</template>

<script>
import {socialDateFormat} from '../../utils'

export default {
  name: 'Edit',
  data () {
    return {
      isSubmit: false,
      id: 0,
      content: '',
      hint: '新微博'
    }
  },
  created () {
    this.id = this.$route.params.id
    this.setInfo()
  },
  methods: {
    goBack () {
      this.$router.replace('/')
    },
    setInfo () {
      if (this.id > 0) {
        this.$http({
          url: this.$http.adornUrl('/weibo/' + this.id),
          method: 'get'
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.hint = '发布于：' + socialDateFormat(data.weibo.time)
            this.content = data.weibo.content
          } else {
            this.$message.error(data.msg)
          }
        })
      }
    },
    submit () {
      if (this.id > 0) {
        this.$http({
          url: this.$http.adornUrl('/modify'),
          method: 'put',
          data: {
            'id': this.id,
            'content': this.content,
            'time': null
          }
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.isSubmit = true
            this.goBack()
          } else {
            this.$message.error(data.code + ' : ' + data.msg)
          }
        })
      } else {
        this.$http({
          url: this.$http.adornUrl('/add'),
          method: 'post',
          data: {
            'id': null,
            'content': this.content,
            'time': null
          }
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.isSubmit = true
            this.goBack()
          } else {
            this.$message.error(data.code + ' : ' + data.msg)
          }
        })
      }
    }
  },
  beforeRouteLeave (to, from, next) {
    if (!this.$store.state.isLogin) {
      next()
    } else {
      if (!this.isSubmit) {
        this.$confirm('检测到未保存的内容，是否在离开页面前提交修改？', '确认信息', {
          distinguishCancelAndClose: true,
          confirmButtonText: '提交',
          cancelButtonText: '放弃修改'
        })
          .then(() => {
            this.submit()
            this.$message({
              type: 'success',
              message: '已提交'
            })
            next()
          })
          .catch(action => {
            if (action === 'cancel') {
              this.$message({
                type: 'info',
                message: '已舍弃'
              })
              next()
            } else {
              next(false)
            }
          })
      } else {
        this.$message({
          type: 'success',
          message: '提交成功'
        })
        next()
      }
    }
  }
}
</script>

<style scoped>
  .edit-page {
    margin: 10px 30px 30px;
    height: 100%;
  }
</style>
