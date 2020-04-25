import Vue from 'vue'
import axios from 'axios'
import qs from 'qs' // 字符串处理
import router from '@/router'
import merge from 'lodash/merge' // 合并对象工具

const http = axios.create({
  timeout: 1000 * 30,
  withCredentials: true, // 当前请求为跨域类型时是否在请求中协带cookie
  headers: {
    'Content-Type': 'application/json;charset=utf-8'
  }
})

/**
 * 请求地址处理
 * @param {*} actionName action方法名称
 */
http.adornUrl = (actionName) => {
  // 非生产环境 && 开启代理, 接口前缀统一使用[/proxyApi/]前缀做代理拦截!
  return 'http://localhost:8080/weibo' + actionName
}

/**
 * 请求拦截
 */
http.interceptors.request.use(config => {
  // 处理请求之前的配置
  config.headers['token'] = Vue.cookie.get('token') // // 请求头带上token
  return config
}, error => {
  // 请求失败的处理
  return Promise.reject(error)
})

/**
 * 响应拦截
 */
http.interceptors.response.use(response => {
  if (response.data && response.data.code === 1002) {
    Vue.cookie.delete('token')// 401 token失效
    router.push({ name: 'Login' })
  }
  return response
}, error => {
  return Promise.reject(error)
})

/**
 * get 请求参数处理
 * @param params
 * @param openDefaultParams
 * @returns {*}
 */
http.adornParams = (params = {}, openDefaultParams = false) => {
  var defaluts = {
    't': new Date().getTime()
  }
  return openDefaultParams ? merge(defaluts, params) : params
}
/**
 * post请求参数处理
 * @param data
 * @param openDefaultdata
 * @param contentType
 * @returns {string}
 */
http.adornData = (data = {}, openDefaultdata = false, contentType = 'json') => {
  var defaults = {
    't': new Date().getTime()
  }
  data = openDefaultdata ? merge(defaults, data) : data
  return contentType === 'json' ? JSON.stringify(data) : qs.stringify(data)
}

export default http
