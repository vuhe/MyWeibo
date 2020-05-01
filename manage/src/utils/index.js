/**
 * [Date 时间戳转字符串格式]
 */
export function socialDateFormat (date) {
  date = new Date(parseInt(date))
  let month = (date.getMonth() + 1).toString()
  let day = date.getDate().toString()
  let hours = date.getHours().toString()
  let minutes = date.getMinutes().toString()
  if (date.getMonth() + 1 < 10) {
    month = '0' + month
  }
  if (date.getDate() < 10) {
    day = '0' + day
  }
  if (date.getHours() < 10) {
    hours = '0' + hours
  }
  if (date.getMinutes() < 10) {
    minutes = '0' + minutes
  }
  return date.getFullYear() + '-' + month + '-' + day +
    ' ' + hours + ':' + minutes
}
