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
  if (time < 60 * 10) { // 十分钟内
    return '刚刚'
  } else if ((time < 60 * 60) && (time >= 60 * 10)) {
    // 超过十分钟少于1小时
    s = Math.floor(time / 60)
    return s + '分钟前'
  } else if ((timeNow.getDate() - nDate.getDate() < 1) && (time >= 60 * 60)) {
    // 超过1小时且在同一天
    s = Math.floor(time / 60 / 60)
    return s + '小时前'
  } else if (timeNow.getDate() - nDate.getDate() === 1) {
    // 相差一天
    s = Math.floor(time / 60 / 60 / 24)
    return '昨天 ' + nDate.getHours() + ':' + nDate.getMinutes()
  } else if (timeNow.getDate() - nDate.getDate() === 2) {
    // 相差两天
    s = Math.floor(time / 60 / 60 / 24)
    return '前天 ' + nDate.getHours() + ':' + nDate.getMinutes()
  } else {
    // 超过3天
    date = new Date(parseInt(date))
    return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() +
      ' ' + nDate.getHours() + ':' + nDate.getMinutes()
  }
}
