import React, { useState } from 'react';
import styles from './FeedbackSection.module.css';
import Button from '@mui/material/Button';
import Rating from '@mui/material/Rating';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';

const FeedbackSection: React.FC = () => {
  const [rating, setRating] = useState<number | null>(2.5);
  const [feedback, setFeedback] = useState<string>('');
  const [name, setName] = useState<string>('');

  const handleSubmit = () => {
    // Handle feedback submission
    console.log({ rating, feedback, name });
  };

  return (
    <div className={styles.container}>
      <Typography variant="h4" className={styles.title}>Отзывы</Typography>
      
      <div className={styles.feedbackItem}>
        <div className={styles.feedbackHeader}>
          <Typography variant="h5" className={styles.userName}>Аноним</Typography>
          <Rating name="read-only" value={3.5} precision={0.5} readOnly className={styles.ratingDisplay} />
        </div>
        <Typography variant="body1" className={styles.feedbackText}>
          Текст отзыва. Текст отзыва. Текст отзыва. Текст отзыва. 
          Текст отзыва. Текст отзыва. Текст отзыва. Текст отзыва.
        </Typography>
      </div>

      <div className={styles.feedbackInput}>
        <Typography variant="h6" className={styles.inputTitle}>Оставьте отзыв</Typography>
        <TextField
          label="Ваше имя"
          variant="outlined"
          fullWidth
          value={name}
          onChange={(e) => setName(e.target.value)}
          className={styles.nameInput}
        />
        <TextField
          label="Ваш отзыв"
          variant="outlined"
          fullWidth
          multiline
          rows={4}
          value={feedback}
          onChange={(e) => setFeedback(e.target.value)}
          className={styles.feedbackTextarea}
        />
        <div className={styles.inputFooter}>
          <Rating
            name="simple-controlled"
            value={rating}
            precision={0.5}
            onChange={(event, newValue) => {
              setRating(newValue);
            }}
            className={styles.ratingInput}
          />
          <Button variant="outlined" onClick={handleSubmit} className={styles.submitButton}>
            Отправить
          </Button>
        </div>
      </div>
    </div>
  );
};

export default FeedbackSection;

