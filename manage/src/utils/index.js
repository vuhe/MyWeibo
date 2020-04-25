/**
 * [Date 时间戳转字符串格式]
 */
export function socialDateFormat (date) {
  date = new Date(parseInt(date))
  return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() +
    ' ' + date.getHours() + ':' + date.getMinutes()
}
