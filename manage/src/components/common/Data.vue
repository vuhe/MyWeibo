<template>
    <div class="data-page">
      <el-button-group style="margin-bottom: 10px; float: left;">
        <el-button
          type="primary"
          icon="el-icon-delete"
          @click="deleteSelectData">删除所选</el-button>
        <el-button
          type="primary"
          icon="el-icon-edit"
          @click="newEdit">新增博文</el-button>
      </el-button-group>
      <el-table
        border
        :max-height="tableHeight"
        id="data-table"
        ref="multipleTable"
        :data="list"
        tooltip-effect="dark"
        style="width: 100%; height: inherit;"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          label="Id"
          prop="id"
          width="60">
        </el-table-column>
        <el-table-column
          prop="time"
          label="时间"
          width="140">
        </el-table-column>
        <el-table-column
          prop="content"
          label="内容"
          show-overflow-tooltip>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="gotoEdit(scope.$index)"
              type="text"
              size="small">
              修改
            </el-button>
            <el-button
              @click.native.prevent="deleteData([scope.$index])"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        style="margin: 15px;"
        @current-change="getData"
        :current-page.sync="currentPage"
        :page-size="10"
        layout="prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
</template>

<script>
import {socialDateFormat} from '../../utils'

export default {
  name: 'Data',
  data () {
    return {
      page: 0,
      pageSize: 1,
      total: 1,
      currentPage: 1,
      list: [],
      tableHeight: 100000,
      multipleSelection: []
    }
  },
  created () {
    this.getData(this.currentPage)
  },
  mounted () {
    this.getTableHeight()
  },
  methods: {
    getTableHeight () {
      let dataHeight = document.getElementById('main').clientHeight
      dataHeight = dataHeight - 112
      this.tableHeight = dataHeight
      document.getElementById('data-table').style.height = dataHeight + 'px'
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/userPage/' + page),
        method: 'get'
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.list = []
          this.total = data.page.total
          data.page.records.forEach((i) => {
            let a = {}
            a.id = i.id
            a.content = i.content
            a.time = socialDateFormat(i.time)
            this.list.push(a)
          })
        } else {
          this.$message.error(data.code + ' : ' + data.msg)
        }
      })
    },
    getId (index) {
      return this.list[index].id
    },
    deleteData (numList) {
      this.$http({
        url: this.$http.adornUrl('/delete'),
        method: 'delete',
        data: this.$http.adornData(numList)
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.getData(this.currentPage)
        } else {
          this.$message.error(data.code + ' : ' + data.msg)
        }
      })
    },
    deleteSelectData () {
      let d = []
      this.multipleSelection.forEach((i) => {
        d.push(i.id)
      })
      this.deleteData(d)
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    gotoEdit (index) {
      let id = this.getId(index)
      this.$router.replace('/edit/' + id)
    },
    newEdit () {
      this.$router.replace('/edit/0')
    }
  }
}
</script>

<style scoped>
.data-page {
  margin: 10px 30px 30px;
  height: 100%;
}
</style>
