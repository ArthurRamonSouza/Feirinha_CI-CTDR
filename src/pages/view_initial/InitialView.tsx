import React from 'react'
import './initialView.css'
import { HeaderSearchBar } from '../../components/HeaderSearchBar'
import Products from '../../components/products/Products'

const InitialView = () => {
  return (
    <div className='ad-view initial'>
        <HeaderSearchBar />
        <div className='cards-adjust'>
        <Products />
        </div>
        
    </div>
  )
}

export default InitialView