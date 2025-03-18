import React from 'react';
import styles from './ProductLayout.module.css';
import ProductHeader from './ProductHeader';
import ProductDetails from './ProductDetails';
import ProductOptions from './ProductOptions';
import ActionButton from './ActionButton';
import ProductDescription from './ProductDescription';
import VendorInfo from './VendorInfo';
import FeedbackSection from './FeedbackSection';

const ProductLayout: React.FC = () => {
  return (
    <div className={styles.container}>
      <ProductHeader />
      <div className={styles.mainContent}>
        <ProductDetails />
        <ProductOptions />
      </div>
      <ActionButton />
      <ProductDescription />
      <VendorInfo />
      <FeedbackSection />
    </div>
  );
};

export default ProductLayout;

