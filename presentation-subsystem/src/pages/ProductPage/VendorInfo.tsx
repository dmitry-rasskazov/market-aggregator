import React from 'react';
import styles from './VendorInfo.module.css';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';

interface VendorInfoProps {
  vendorName?: string;
  websiteUrl?: string;
  rating?: number;
  vendorImage?: string;
}

const VendorInfo: React.FC<VendorInfoProps> = ({
  vendorName = "Полное имя вендора",
  websiteUrl = "https://website.com/",
  rating = 4.5,
  vendorImage = "https://dashboard.codeparrot.ai/api/image/Z9lB0yppvFKitUWb/изображе.png"
}) => {
  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <Typography variant="h6" className={styles.vendorName}>{vendorName}</Typography>
        <a href={websiteUrl} className={styles.website}>{websiteUrl}</a>
        <Rating
          name="vendor-rating"
          value={rating}
          precision={0.5}
          readOnly
          className={styles.rating}
        />
      </div>
      <img src={vendorImage} alt="Vendor" className={styles.vendorImage} />
    </div>
  );
};

export default VendorInfo;

