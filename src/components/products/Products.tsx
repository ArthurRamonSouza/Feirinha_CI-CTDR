
import { useState } from 'react'
import './products.css'
import { useEffect } from 'react'
import fetchProducts from '../../utils'
import Card from '../card/Card'

function Products()  {

    const [products, setProducts] = useState([])

    useEffect(() => {

        fetchProducts("iphone").then((response) => {
            setProducts(response)
        })
    }, [])

  return (
    <section className="products">
      {
        products.map((product) => <Card key={product.id} data={product} />)
      }
    </section>
  )
}

export default Products