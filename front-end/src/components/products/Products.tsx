import { useState } from 'react'
import './products.css'
import { useEffect } from 'react'
import fetchProducts from '../../api'
import Card from '../card/Card'
import Loading from '../loading/Loading'

function Products()  {

  
  const[products, setProducts] = useState([])  
  
  const [loading, setLoading] = useState(true);
    
    useEffect(() => {

        fetchProducts("em alta").then((response) => {
            setProducts(response)
            setLoading(false)
        })
    }, [])

  return (
    (loading && <Loading /> ) || (
      
      <section className="products">
        
       {
          products.map((product: any) => <Card key={product.id} data={product} />)
        }
      </section>
    )
  )
}

export default Products