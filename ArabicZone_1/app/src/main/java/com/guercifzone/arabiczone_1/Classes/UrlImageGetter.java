package com.guercifzone.arabiczone_1.Classes;



import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.guercifzone.arabiczone_1.R;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;


public class UrlImageGetter implements Html.ImageGetter {
    private TextView textView;
    private Picasso picasso;

    public UrlImageGetter(TextView textView) {
        this.textView = textView;
        this.picasso = picasso;
    }

    @Override
    public Drawable getDrawable(String source) {
        Log.d(UrlImageGetter.class.getName(), "Start loading url " + source);

        BitmapDrawablePlaceHolder drawable = new BitmapDrawablePlaceHolder();

        picasso
                .load(source)
                .error(R.drawable.ca22lp01)
                .into((com.squareup.picasso.Target) drawable);

        return drawable;
    }
    private class BitmapDrawablePlaceHolder extends BitmapDrawable implements Target {

        protected Drawable drawable;

        @Override
        public void draw(final Canvas canvas) {
            if (drawable != null) {
                checkBounds();
                drawable.draw(canvas);
            }
        }

        public void setDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                this.drawable = drawable;
                checkBounds();
            }
        }

        private void checkBounds() {
            float defaultProportion = (float) drawable.getIntrinsicWidth() / (float) drawable.getIntrinsicHeight();
            int width = Math.min(textView.getWidth(), drawable.getIntrinsicWidth());
            int height = (int) ((float) width / defaultProportion);

            if (getBounds().right != textView.getWidth() || getBounds().bottom != height) {

                setBounds(0, 0, textView.getWidth(), height); //set to full width

                int halfOfPlaceHolderWidth = (int) ((float) getBounds().right / 2f);
                int halfOfImageWidth = (int) ((float) width / 2f);

                drawable.setBounds(
                        halfOfPlaceHolderWidth - halfOfImageWidth, //centering an image
                        0,
                        halfOfPlaceHolderWidth + halfOfImageWidth,
                        height);

                textView.setText(textView.getText()); //refresh text
            }
        }

        //------------------------------------------------------------------//


        @Override
        public void onStart() {

        }

        @Override
        public void onStop() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public void onLoadStarted(@Nullable @org.jetbrains.annotations.Nullable Drawable drawable) {

        }

        @Override
        public void onLoadFailed(@Nullable @org.jetbrains.annotations.Nullable Drawable drawable) {

        }

        @Override
        public void onResourceReady(@NonNull @NotNull Object o, @Nullable @org.jetbrains.annotations.Nullable Transition transition) {

        }

        @Override
        public void onLoadCleared(@Nullable @org.jetbrains.annotations.Nullable Drawable drawable) {

        }

        @Override
        public void getSize(@NonNull @NotNull SizeReadyCallback sizeReadyCallback) {

        }

        @Override
        public void removeCallback(@NonNull @NotNull SizeReadyCallback sizeReadyCallback) {

        }

        @Override
        public void setRequest(@Nullable @org.jetbrains.annotations.Nullable Request request) {

        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public Request getRequest() {
            return null;
        }


        //------------------------------------------------------------------//

    }
}
  