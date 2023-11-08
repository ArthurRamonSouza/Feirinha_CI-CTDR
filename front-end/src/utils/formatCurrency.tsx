const formatCurrency = (value: any, currency: any) => {
    return value.toLocaleString('pt-br', {
        style: 'currency',
        currency
      })
}
export default formatCurrency