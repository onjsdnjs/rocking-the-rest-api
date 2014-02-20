package kr.pe.ihoney.jco.restapi.web.support.converter;

import java.util.Set;

import kr.pe.ihoney.jco.restapi.domain.Group;
import kr.pe.ihoney.jco.restapi.domain.Member;
import kr.pe.ihoney.jco.restapi.domain.Post;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.util.NumberUtils;

import com.google.common.collect.Sets;

public class LongIdTypeEntityConverter extends AbstractEntityConverter<Long> {

    @Override
    Set<ConvertiblePair> initConvertiblePairs() {
        Set<Class<?>> targetTypes = Sets.newHashSet();
        targetTypes.add(Member.class);
        targetTypes.add(Group.class);
        targetTypes.add(Post.class);

        Set<ConvertiblePair> convertiblePairs = Sets.newHashSet();
        for (Class<?> targetType : targetTypes) {
            convertiblePairs.add(new ConvertiblePair(Long.class, targetType));
            convertiblePairs.add(new ConvertiblePair(String.class, targetType));
        }
        return convertiblePairs;
    }

    @Override
    Long convertId(Object source, TypeDescriptor sourceType) {
        if (Long.class.equals(sourceType.getType())) {
            return (Long) source;
        } else {
            return NumberUtils.parseNumber(source.toString(), Long.class);
        }
    }

}
