import React from 'react'
import './card.css'
import propTypes from 'prop-types'
import formatCurrency from '../../utils/formatCurrency'
import { Link } from 'react-router-dom'


const Card = ({data}: any) => {

  const { title, thumbnail, price } = data;
  return (
    <section className='product-card'>
      
      <div className='image-adjust'>
        <Link to={'/adview'}>
        <img 
        src={thumbnail.replace(/\w\.jpg/gi, "W.jpg")}
        alt='product' 
        className='card-image' 
      />
        </Link>
      
      </div>
      <div className='card-infos'>
        <h2 className='card-price'>{formatCurrency(price, 'BRL')}</h2>
        <h2 className='card-title'>{title}</h2>
      </div>
    </section>
  )
}

export default Card

Card.propTypes = {
  data: propTypes.shape({}).isRequired
}