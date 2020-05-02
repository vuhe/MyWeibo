/**
 * [Date 时间戳转字符串格式]
 */
export function socialDateFormat (date) {
  // 获取 date 的 Date 对象
  let nDate = new Date(parseInt(date))
  // 获取 js 时间戳
  let timeNow = new Date()
  // 去掉 js 时间戳后三位
  let time = parseInt((timeNow.getTime() - date) / 1000)
  // 存储转换值
  let s
  // 时分转换
  let month = (nDate.getMonth() + 1).toString()
  let day = nDate.getDate().toString()
  let hours = nDate.getHours().toString()
  let minutes = nDate.getMinutes().toString()
  if (nDate.getMonth() + 1 < 10) {
    month = '0' + month
  }
  if (nDate.getDate() < 10) {
    day = '0' + day
  }
  if (nDate.getHours() < 10) {
    hours = '0' + hours
  }
  if (nDate.getMinutes() < 10) {
    minutes = '0' + minutes
  }
  // 逻辑判断
  if (time < 60 * 10) { // 十分钟内
    return '刚刚'
  } else if ((time < 60 * 60) && (time >= 60 * 10)) {
    // 超过十分钟少于1小时
    s = Math.floor(time / 60)
    return s + '分钟前'
  } else if ((timeNow.getDate() - nDate.getDate() === 0) && (time >= 60 * 60)) {
    // 超过1小时且在同一天
    s = Math.floor(time / 60 / 60)
    return s + '小时前'
  } else if (timeNow.getDate() - nDate.getDate() === 1) {
    // 相差一天
    return '昨天 ' + hours + ':' + minutes
  } else if (timeNow.getDate() - nDate.getDate() === 2) {
    // 相差两天
    return '前天 ' + hours + ':' + minutes
  } else {
    // 超过3天
    return nDate.getFullYear() + '-' + month + '-' + day +
      ' ' + hours + ':' + minutes
  }
}

/**
 * 对内容的链接及换行进行处理
 *
 * @param content
 * @returns {*}
 */
export function contentFormat (content) {
  // 替换换行、空格
  content = content.replace(/\n/g, '<br/>').replace(/\s/g, ' ')

  // 替换链接
  // eslint-disable-next-line
  let re = /\[[\s\S]*?\]\((http|ftp|https):\/\/[\w-]+(.[\w-]+)+([\w-.,@?^=%&:/~+#]*[\w-\@?^=%&/~+#])?\)/g
  content = content.replace(re, function (website) {
    let name = website.replace(/\([\s\S]*?\)/g, '').replace(/\[[\s\S]*?\]/g, function (name) {
      return name.substring(1, name.length - 1)
    })
    let path = website.replace(/\[[\s\S]*?\]/g, '').replace(/\([\s\S]*?\)/g, function (path) {
      return path.substring(1, path.length - 1)
    })
    return "<a href='" + path + "' target='_blank'>" + name + '</a>'
  })

  return content
}
