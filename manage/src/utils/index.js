/**
 * [Date 时间戳转字符串格式]
 */
export function socialDateFormat (date) {
  date = new Date(parseInt(date))
  let hours = date.getHours().toString()
  let minutes = date.getMinutes().toString()
  if (date.getHours() < 10) {
    hours = '0' + hours
  }
  if (date.getMinutes() < 10) {
    minutes = '0' + minutes
  }
  return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() +
    ' ' + hours + ':' + minutes
}
