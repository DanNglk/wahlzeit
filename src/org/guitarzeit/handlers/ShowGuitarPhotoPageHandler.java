package org.guitarzeit.handlers;

import org.guitarzeit.model.Guitar;
import org.guitarzeit.model.GuitarPhoto;
import org.wahlzeit.handlers.PartUtil;
import org.wahlzeit.handlers.ShowPhotoPageHandler;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.UserSession;
import org.wahlzeit.webparts.WebPart;

/**
 * Created by cdan on 04/12/14.
 */
public class ShowGuitarPhotoPageHandler extends ShowPhotoPageHandler {

    @Override
    protected void makePhotoCaption(UserSession us, WebPart page) {
        GuitarPhoto photo = (GuitarPhoto) us.getPhoto();

        WebPart caption = createWebPart(us, PartUtil.CAPTION_INFO_FILE);
        caption.addString(Photo.LOCATION_CAPTION, photo.getLocation().asString());
        caption.addString(Guitar.TYPE_CAPTION, photo.getGuitar().getGuitarType().name());
        caption.addString(Guitar.SHAPE_CAPTION, photo.getGuitar().getGuitarShape().name());
        caption.addString(Guitar.STRINGS_CAPTION, photo.getGuitar().getGuitarStrings().asString());
        caption.addString(Guitar.FRETS_CAPTION, photo.getGuitar().getFrets() + "");
        caption.addString(Guitar.FEATURES_CAPTION, photo.getGuitar().getFeatures());
        caption.addString(Guitar.PICKUPS_CAPTION, photo.getGuitar().getPickups() + "");

        page.addWritable(Photo.CAPTION, caption);
    }
}
